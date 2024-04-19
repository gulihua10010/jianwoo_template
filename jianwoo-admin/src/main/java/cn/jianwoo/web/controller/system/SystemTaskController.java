package cn.jianwoo.web.controller.system;

import cn.hutool.core.collection.CollUtil;
import cn.jianwoo.common.core.domain.AjaxResult;
import cn.jianwoo.common.enums.ProcessStatus;
import cn.jianwoo.quartz.domain.SysJob;
import cn.jianwoo.quartz.service.ISysJobService;
import cn.jianwoo.system.domain.AsyncProcAutoTask;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jianwoo.common.annotation.Log;
import cn.jianwoo.common.core.controller.BaseController;
import cn.jianwoo.common.core.domain.R;
import cn.jianwoo.system.service.IAsyncProcAutoTaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

/**
 * 自动任务模块
 * 
 * @author jianwoo
 * @date 2023-08-22
 */
@RestController
@RequestMapping("/system/task")
@Tag(name = "系统任务模块")
public class SystemTaskController extends BaseController
{
    @Autowired
    private IAsyncProcAutoTaskService asyncProcAutoTaskService;
    @Autowired
    private ISysJobService jobService;

    /**
     * 执行自动任务
     */
    @Operation(summary = "执行自动任务", description = "执行自动任务")
    @GetMapping("/auto/exec")
    @Log
    public R execAutoTask()
    {
        AsyncProcAutoTask query = new AsyncProcAutoTask();
        query.setStatusProc(ProcessStatus.INIT.getValue());
        List<AsyncProcAutoTask> list = asyncProcAutoTaskService.queryAsyncProcAutoTaskList(query);
        if (CollUtil.isNotEmpty(list))
        {
            for (AsyncProcAutoTask task : list)
            {
                asyncProcAutoTaskService.doSendTask(task.getTaskId());
            }
        }
        return ok();
    }


    /**
     * 执行定时任务
     */
    @Operation(summary = "执行定时任务", description = "执行定时任务")
    @PostMapping("/schedule/exec")
    @Log
    public AjaxResult execScheduleTask(@RequestBody
    SysJob job) throws SchedulerException
    {
        boolean result = jobService.run(job);
        return result ? success() : error("任务不存在或已过期！");
    }

}
