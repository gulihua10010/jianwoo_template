package cn.jianwoo.quartz.util;

import org.quartz.JobExecutionContext;
import cn.jianwoo.quartz.domain.SysJob;

/**
 * 定时任务处理（允许并发执行）
 * 
 * @author jianwoo
 *
 */
public class QuartzJobExecution extends AbstractQuartzJob
{
    @Override
    protected void doExecute(JobExecutionContext context, SysJob sysJob) throws Exception
    {
        JobInvokeUtil.invokeMethod(sysJob);
    }
}
