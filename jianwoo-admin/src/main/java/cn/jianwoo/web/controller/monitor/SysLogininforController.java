package cn.jianwoo.web.controller.monitor;

import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.common.utils.bean.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jianwoo.common.annotation.BizOptLog;
import cn.jianwoo.common.annotation.Log;
import cn.jianwoo.common.core.controller.BaseController;
import cn.jianwoo.common.core.domain.R;
import cn.jianwoo.common.core.page.TableDataInfo;
import cn.jianwoo.common.enums.BusinessType;
import cn.jianwoo.common.utils.bean.CopyBeanUtil;
import cn.jianwoo.common.utils.poi.ExcelUtil;
import cn.jianwoo.framework.web.service.SysPasswordService;
import cn.jianwoo.system.domain.SysLogininfor;
import cn.jianwoo.system.service.ISysLogininforService;
import cn.jianwoo.web.dto.log.SysLogininforVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 系统访问记录
 * 
 * @author jianwoo
 */
@RestController
@RequestMapping("/monitor/logininfor")
@Tag(name = "系统访问记录")
public class SysLogininforController extends BaseController
{
    @Autowired
    private ISysLogininforService logininforService;

    @Autowired
    private SysPasswordService passwordService;

    @PreAuthorize("@ss.hasPermi('monitor:logininfor:list')")
    @GetMapping("/list")
    @Operation(summary = "查询登录日志", description = "查询登录日志")
    @Log
    public TableDataInfo<SysLogininforVO> list(SysLogininforVO logininfor)
    {
        Page page = startPage();
        SysLogininfor query = CopyBeanUtil.copyProperties(logininfor, SysLogininfor::new);
        query.getParams().put("beginTime", logininfor.getBeginTime());
        query.getParams().put("endTime", logininfor.getEndTime());
        List<SysLogininfor> list = logininforService.selectLogininforList(query);
        List<SysLogininforVO> resList = new ArrayList<>();
        if (CollUtil.isNotEmpty(list))
        {
            for (SysLogininfor domain : list)
            {
                SysLogininforVO vo = new SysLogininforVO();
                BeanUtils.copyProperties(domain, vo);
                if (StrUtil.isNotBlank(domain.getMsg()) && domain.getMsg().contains("."))
                {
                    vo.setMsg(MessageUtils.message(domain.getMsg()));
                }
                resList.add(vo);
            }
        }
        return getDataTable(resList, page);
    }


    @BizOptLog(title = "登录日志", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('monitor:logininfor:export')")
    @PostMapping("/export")
    @Operation(summary = "导出登录日志", description = "导出登录日志")
    @Log
    public void export(SysLogininforVO logininfor)
    {
        SysLogininfor query = CopyBeanUtil.copyProperties(logininfor, SysLogininfor::new);
        query.getParams().put("beginTime", logininfor.getBeginTime());
        query.getParams().put("endTime", logininfor.getEndTime());
        List<SysLogininfor> list = logininforService.selectLogininforList(query);
        List<SysLogininforVO> resList = new ArrayList<>();
        if (CollUtil.isNotEmpty(list))
        {
            for (SysLogininfor domain : list)
            {
                SysLogininforVO vo = new SysLogininforVO();
                BeanUtils.copyProperties(domain, vo);
                if (StrUtil.isNotBlank(domain.getMsg()) && domain.getMsg().contains("."))
                {
                    vo.setMsg(MessageUtils.message(domain.getMsg()));
                }
                resList.add(vo);
            }
        }
        ExcelUtil<SysLogininforVO> util = new ExcelUtil<SysLogininforVO>(SysLogininforVO.class);
        util.exportExcel(response, resList, "登录日志");
    }


    @PreAuthorize("@ss.hasPermi('monitor:logininfor:remove')")
    @BizOptLog(title = "登录日志", businessType = BusinessType.DELETE)
    @DeleteMapping("/{infoIds}")
    @Operation(summary = "删除登录日志", description = "删除登录日志")
    @Parameter(name = "infoIds", description = "登录日志id列表", in = ParameterIn.PATH, required = true)
    @Log
    public R remove(@PathVariable
    Long[] infoIds)
    {
        return ok(logininforService.deleteLogininforByIds(infoIds));
    }


    @PreAuthorize("@ss.hasPermi('monitor:logininfor:remove')")
    @BizOptLog(title = "登录日志", businessType = BusinessType.CLEAN)
    @DeleteMapping("/clean")
    @Operation(summary = "清除登录日志", description = "清除登录日志")
    @Log
    public R clean()
    {
        logininforService.cleanLogininfor();
        return ok();
    }


    @PreAuthorize("@ss.hasPermi('monitor:logininfor:unlock')")
    @BizOptLog(title = "账户解锁", businessType = BusinessType.OTHER)
    @GetMapping("/unlock/{userName}")
    @Operation(summary = "账户解锁", description = "账户解锁")
    @Parameter(name = "userName", description = "用户名", in = ParameterIn.PATH, required = true)
    @Log
    public R unlock(@PathVariable("userName")
    String userName)
    {
        passwordService.clearLoginRecordCache(userName);
        return ok();
    }
}
