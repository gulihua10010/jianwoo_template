<template>
  <div class="app-container">

    <el-upload
      class="upload-demo"
      :file-list="fileList1"
      action=""
      :http-request="handleUpload"
    >        <el-button size="small" type="primary">点击上传</el-button>
      <div slot="tip" class="el-upload__tip">
        支持扩展名：.ppt、.pdf、.zip、.doc、.docx
      </div>
    </el-upload>
  </div>
</template>

<script>
import { queryOss} from "@/api/system/project";
const OSS = require('ali-oss');
export default {
  name: "Project",
  data() {
    return {
      client:null,
      fileList1:[]
    };
  },
  created() {
    // this.getList();
    queryOss().then(response => {
      console.log(response)
      this. client = new OSS({
        // yourRegion填写Bucket所在地域。以华东1（杭州）为例，Region填写为oss-cn-hangzhou。
        region: 'oss-'+response.data.region,
        // 从STS服务获取的临时访问密钥（AccessKey ID和AccessKey Secret）。
        accessKeyId: response.data.accessKeyId,
        accessKeySecret: response.data.accessKeySecret,
        // 从STS服务获取的安全令牌（SecurityToken）。
        stsToken: response.data.securityToken,
        // 刷新临时访问凭证的时间间隔，单位为毫秒。
        refreshSTSTokenInterval: 300000,
        // 填写Bucket名称。
        bucket: response.data.bucket,
      });
      // 从输入框获取file对象，例如<input type="file" id="file" />。
      // 创建并填写Blob数据。
      //const data = new Blob(['Hello OSS']);
      // 创建并填写OSS Buffer内容。
      //const data = new OSS.Buffer(['Hello OSS']);

      const data = new OSS.Buffer(['Hello OSS']);
      let that=this
      try {
        // 填写Object完整路径。Object完整路径中不能包含Bucket名称。
        // 您可以通过自定义文件名（例如exampleobject.txt）或文件完整路径（例如exampledir/exampleobject.txt）的形式实现将数据上传到当前Bucket或Bucket中的指定目录。
        // data对象可以自定义为file对象、Blob数据或者OSS Buffer。
        const options = {
          meta: { temp: "demo" },
          mime: "json",
          headers: { "Content-Type": "text/plain" },
        };
        const result = that.client.put("examplefile.txt", data, options);
        console.log(result);
      } catch (e) {
        console.log(e);
      }


    });

  },
  methods: {
    handleUpload(op) {
      let dir = `images`;
      try {
        // 填写Object完整路径。Object完整路径中不能包含Bucket名称。
        // 您可以通过自定义文件名（例如exampleobject.txt）或文件完整路径（例如exampledir/exampleobject.txt）的形式实现将数据上传到当前Bucket或Bucket中的指定目录。
        // data对象可以自定义为file对象、Blob数据或者OSS Buffer。
        const options = {
          meta: { temp: "demo" },
          mime: "json",
          headers: { "Content-Type": "text/plain" },
        };
        const result =   this.client.put("examplefile.txt", op.file, options);
        console.log(result);
      } catch (e) {
        console.log(e);
      }
    },
  }
};
</script>
