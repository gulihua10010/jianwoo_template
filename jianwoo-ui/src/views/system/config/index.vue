<template>
  <div class="app-container" v-loading="loading">
    <el-tabs v-model="activeName" @tab-click="handleClick">
      <el-tab-pane :label="item.tabNameDsp" :name="item.tabCode" v-for="(item,index) in config.dataList"
                   :key="item.tabCode">
        <el-form ref="configForm" :model="form" label-width="130px" :rules="rules">
          <el-form-item :label="cfg.titleDsp" v-for="cfg in item.list" :key="cfg.key" :prop="cfg.key">

            <el-input v-model="form[cfg.key]" v-if="cfg.formType === 'input_text' && cfg.key!=='sys_admin_email_address'"
                      style="width: 90%;display: inline-block"/>
            <el-input v-model="form[cfg.key]" v-if="cfg.formType === 'input_text' && cfg.key==='sys_admin_email_address'"
                      style="width: 90%;">
              <el-button type="primary" v-if="cfg.key==='sys_admin_email_address'" slot="append"
                         @click="sendEmailTest(cfg.value)" :loading="emailloading" style="background-color: #448ef7;color:white">测试
              </el-button>

            </el-input>
            <el-input type="textarea" v-model="form[cfg.key]" :autosize="{ minRows: 5, maxRows: 9}"
                      v-if="cfg.formType === 'textarea'" style="width: 90%;display: inline-block"></el-input>
            <el-upload
              v-if="cfg.formType === 'input_file_image'"
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="header"
              :show-file-list="false"
              :on-success="(response, file, fileList)=>{return handleAvatarSuccess(response, file, fileList, cfg)}"
              :before-upload="beforeAvatarUpload" style="display: inline-block">
              <img v-if="form[cfg.key]" :src="form[cfg.key]" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <el-input v-model.number="form[cfg.key]" autocomplete="off"
                      v-if="cfg.formType === 'input_text_number'" style="width: 90%;display: inline-block"></el-input>
            <el-switch v-model="form[cfg.key]" v-if="cfg.formType === 'input_checkbox'"></el-switch>
            <el-select v-model="form[cfg.key]" placeholder="请选择" v-if="cfg.formType === 'select'">
              <el-option :label="opt.dsp" :value="opt.value" v-for="opt in cfg.options"></el-option>
            </el-select>
            <el-checkbox-group v-model="form[cfg.key]" v-if="cfg.formType === 'multi_checkbox'" size="medium">
              <el-checkbox-button :label="opt.value" :value="opt.value" :key="opt.value" v-for="opt in cfg.options"
                                  :name="cfg.key">{{ opt.dsp }}
              </el-checkbox-button>
            </el-checkbox-group>

            <el-tooltip class="item" effect="dark" :content="cfg.tipsDsp" placement="top" style="margin-left: 10px"
                        v-if="cfg.tipsDsp">
              <svg-icon icon-class="tooltips"/>
            </el-tooltip>

          </el-form-item>
          <el-form-item>
            <el-button type="primary" style="float: right;margin-right: 10%" @click="onSubmit(index)" :loading="optLoading">保存</el-button>
          </el-form-item>
        </el-form>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import {getToken} from '@/utils/auth'
import {sendEmailTest, listConfig, updateConfig} from "@/api/system/config";

var validateNumber = (rule, value, callback, cfg) => {

  var patten = /^(0|([1-9]\d*))(\.\d+)?$/g;
  if (!patten.test(value)) {
    callback(new Error('请输入正确数字!'));
  } else if (cfg.validateValue) {
    let param = JSON.parse(cfg.validateValue)
    let v = Number.parseInt(value)
    if (param && param.minNum && param.minNum.value) {
      if (v < param.minNum.value) {
        return callback(new Error(cfg.titleDsp + '不能小于' + param.minNum.value + '!'));
      }

    }
    if (param && param.maxNum && param.maxNum.value) {
      if (v > param.maxNum.value) {
        return callback(new Error(cfg.titleDsp + '不能大于' + param.maxNum.value + '!'));
      }
    }
  }
  callback();
}
var validateInteger = (rule, value, callback, cfg) => {

  var patten = /^(0|([1-9]\d*))?$/g;

  if (!patten.test(value)) {
    return callback(new Error('请输入正确整数!'));
  } else if (cfg.validateValue) {
    let param = JSON.parse(cfg.validateValue)
    let v = Number.parseInt(value)
    if (param && param.minNum && param.minNum.value) {
      if (v < param.minNum.value) {
        return callback(new Error(cfg.titleDsp + '不能小于' + param.minNum.value + '!'));
      }

    }
    if (param && param.maxNum && param.maxNum.value) {
      if (v > param.maxNum.value) {
        return callback(new Error(cfg.titleDsp + '不能大于' + param.maxNum.value + '!'));
      }
    }
  }
  callback();

}
export default {
  data() {
    return {
      activeName: 'system',
      config: {
        dataList: []
      },
      optLoading: false,
      imageUrl: '',
      uploadUrl: process.env.VUE_APP_BASE_API + "/common/upload", // 上传的图片服务器地址
      header: {'Authorization': getToken()},
      loading: false,
      form: {},
      oldData: {},
      rules: {},
      emailloading:false
    }
  },
  created() {
    this.fetchConfig()

  },
  methods: {
    fetchConfig() {
      this.loading = true
      listConfig().then(response => {
        this.config = response.data.data
        this.config.dataList.forEach(item => {
          item.list.forEach(cfg => {
            let value = cfg.value
            if (cfg.valueType === 'B') {
              value = cfg.value === 'true'
            } else if (cfg.formType === 'multi_checkbox') {
              value = cfg.value ? cfg.value.split(",") : []
            }
            this.$set(this.form, cfg.key, value)
            this.oldData[cfg.key] = cfg
            let rule = []

            if (cfg.required) {
              rule.push({required: true, message: cfg.titleDsp + '不能为空!', trigger: 'change'})
            }
            if (cfg.validateType) {

              let param = {}
              if (cfg.validateValue) {
                param = JSON.parse(cfg.validateValue)
              }
              if (cfg.validateType === 'maxLength') {
                rule.push({
                  max: param.maxLength.value,
                  message: cfg.titleDsp + '不能超过' + param.maxLength.value + "!",
                  trigger: 'change'
                })
              } else if (cfg.validateType === 'integer') {
                rule.push({
                  validator: (rule, value, callback) => validateInteger(rule, value, callback, cfg),
                  trigger: 'change'
                })
              } else if (cfg.validateType === 'number') {
                rule.push({
                  validator: (rule, value, callback) => validateNumber(rule, value, callback, cfg),
                  trigger: 'change'
                })
              }
              this.rules[cfg.key] = rule
            }

          });
        });
        this.loading = false
      })
    },
    onSubmit(index) {
      this.$refs['configForm'][index].validate((valid) => {
        if (valid) {

          // console.log(this.form)
          let obj = {list: []}
          Object.keys(this.form).forEach(key => {
            let value = this.form[key]
            let oldCfg = this.oldData[key]
            let oldValue = oldCfg.value
            if (oldCfg.valueType === 'B') {
              value = value ? 'true' : 'false'
            }
            if (oldCfg.formType === 'multi_checkbox') {
              let tmp = "";
              value.forEach(o => {
                tmp = tmp + o + ","
              })
              value = tmp.substring(0, tmp.length - 1)
            }
            if (value !== oldValue) {
              const cfg = Object.assign({}, oldCfg)
              cfg.value = value
              obj.list.push(cfg)
              console.log(value, oldValue)
            }

          })
          this.optLoading = true
          updateConfig(obj).then(() => {
            this.$notify({
              title: '成功',
              message: '保存成功!',
              type: 'success',
              duration: 2000
            })
          }).finally(res=>{
            this.optLoading = false
          })
        } else {
          this.$notify({
            title: '失败',
            message: '表单验证失败,请修改重试!',
            type: 'error',
            duration: 2000
          })
        }
      })

    },
    onCancel() {
      this.$message({
        message: 'cancel!',
        type: 'warning'
      })
    },
    sendEmailTest(email) {
      this.emailloading = true
      sendEmailTest({emailTo: email}).then(response => {
        this.emailloading = false
        this.$notify({
          title: '成功',
          message: '发送成功!',
          type: 'success',
          duration: 2000
        })
      })
    },
    handleClick(name) {
    },
    handleAvatarSuccess(res, file, fileList, cfg) {
      // this.imageUrl = URL.createObjectURL(file.raw);
      if (res.code === 200 || res.code === 0) {
        this.form[cfg.key] = res.url
      }else{
        this.$modal.msgError(res.msg);
      }
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isPNG = file.type === 'image/png';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG && !isPNG) {
        this.$message.error('上传头像图片只能是 JPG/PNG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return (isJPG || isPNG) && isLt2M;
    },
  },


}
</script>

<style scoped>
.line {
  text-align: center;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  border: 1px dashed #d9d9d9;
  font-size: 28px;
  color: #8c939d;
  width: 100px;
  height: 100px;
  line-height: 100px;
  text-align: center;
}

.avatar {
  width: 100px;
  height: 100px;
  display: block;
}
</style>

