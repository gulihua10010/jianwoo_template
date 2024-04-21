package cn.jianwoo.web.controller.monitor;

import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.Page;
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
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.common.utils.bean.BeanUtils;
import cn.jianwoo.common.utils.bean.CopyBeanUtil;
import cn.jianwoo.common.utils.poi.ExcelUtil;
import cn.jianwoo.system.domain.SysOperLog;
import cn.jianwoo.system.service.SysOperLogService;
import cn.jianwoo.web.dto.log.SysOperLogVO;

import cn.hutool.core.collection.CollUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 操作日志记录
 * 
 * @author jianwoo
 */
@RestController
@RequestMapping("/monitor/operlog")
@Tag(name = "操作日志记录")
public class SysOperlogController extends BaseController
{
    @Autowired
    private SysOperLogService operLogService;

    @PreAuthorize("@ss.hasPermi('monitor:operlog:list')")
    @GetMapping("/list")
    @Operation(summary = "查询操作日志", description = "查询操作日志")
    @Log
    public TableDataInfo<SysOperLogVO> list(SysOperLogVO operLog)
    {
        Page page = startPage();
        SysOperLog query = CopyBeanUtil.copyProperties(operLog, SysOperLog::new);
        query.getParams().put("beginTime", operLog.getBeginTime());
        query.getParams().put("endTime", operLog.getEndTime());
        List<SysOperLog> list = operLogService.selectOperLogList(query);
        List<SysOperLogVO> resList = new ArrayList<>();
        if (CollUtil.isNotEmpty(list))
        {
            for (SysOperLog domain : list)
            {
                SysOperLogVO vo = new SysOperLogVO();
                BeanUtils.copyProperties(domain, vo);
                if (StrUtil.isNotBlank(domain.getTitle()) && domain.getTitle().contains("."))
                {
                    vo.setTitle(MessageUtils.message(domain.getTitle()));
                }
                if (null != domain.getBusinessType())
                {
                    vo.setBusinessTypeDesc(MessageUtils.message(BusinessType.getDesc(domain.getBusinessType())));
                }
                if (null != domain.getOperatorType())
                {
                    vo.setOperatorTypeDesc(MessageUtils.message(BusinessType.getDesc(domain.getOperatorType())));
                }
                resList.add(vo);
            }
        }
        return getDataTable(resList, page);
    }


    @BizOptLog(title = "操作日志", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:export')")
    @PostMapping("/export")
    @Operation(summary = "导出操作日志", description = "导出操作日志")
    @Log
    public void export(SysOperLogVO operLog)
    {
        SysOperLog query = CopyBeanUtil.copyProperties(operLog, SysOperLog::new);
        query.getParams().put("beginTime", operLog.getBeginTime());
        query.getParams().put("endTime", operLog.getEndTime());
        List<SysOperLog> list = operLogService.selectOperLogList(query);
        List<SysOperLogVO> resList = new ArrayList<>();
        if (CollUtil.isNotEmpty(list))
        {
            for (SysOperLog domain : list)
            {
                SysOperLogVO vo = new SysOperLogVO();
                BeanUtils.copyProperties(domain, vo);
                if (StrUtil.isNotBlank(domain.getTitle()) && domain.getTitle().contains("."))
                {
                    vo.setTitle(MessageUtils.message(domain.getTitle()));
                }
                if (null != domain.getBusinessType())
                {
                    vo.setBusinessTypeDesc(MessageUtils.message(BusinessType.getDesc(domain.getBusinessType())));
                }
                if (null != domain.getOperatorType())
                {
                    vo.setOperatorTypeDesc(MessageUtils.message(BusinessType.getDesc(domain.getOperatorType())));
                }
                resList.add(vo);
            }
        }
        ExcelUtil<SysOperLogVO> util = new ExcelUtil<SysOperLogVO>(SysOperLogVO.class);
        util.exportExcel(response, resList, "操作日志");
    }


    @BizOptLog(title = "操作日志", businessType = BusinessType.DELETE)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
    @DeleteMapping("/{operIds}")
    @Operation(summary = "删除操作日志", description = "删除操作日志")
    @Parameter(name = "operIds", description = "操作日志id列表", in = ParameterIn.PATH, required = true)
    @Log
    public R remove(@PathVariable
    Long[] operIds)
    {
        return ok(operLogService.deleteOperLogByIds(operIds));
    }


    @BizOptLog(title = "操作日志", businessType = BusinessType.CLEAN)
    @PreAuthorize("@ss.hasPermi('monitor:operlog:remove')")
    @DeleteMapping("/clean")
    @Operation(summary = "清除操作日志", description = "清除操作日志")
    @Log
    public R clean()
    {
        operLogService.cleanOperLog();
        return ok();
    }
}
