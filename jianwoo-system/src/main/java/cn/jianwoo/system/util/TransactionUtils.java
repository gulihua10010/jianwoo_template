package cn.jianwoo.system.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import cn.jianwoo.system.service.AsyncProcAutoTaskService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gulihua
 * @Description
 * @date 2022-05-09 15:26
 */
@Component
@Slf4j
public class TransactionUtils
{

    @Autowired
    private AsyncProcAutoTaskService asyncProcAutoTaskService;

    public void doTriggerTaskAfterCommit(String taskId)
    {
        if (TransactionSynchronizationManager.isSynchronizationActive())
        {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit()
                {
                    log.info(">> Transactional afterCommit...");
                    asyncProcAutoTaskService.doSendTask(taskId);
                }
            });
        }
        else
        {
            log.info(">> Transaction synchronization is not active");
            asyncProcAutoTaskService.doSendTask(taskId);

        }

    }


    public void doTriggerDelayTaskAfterCommit(String taskId, Long delayTime)
    {
        if (TransactionSynchronizationManager.isSynchronizationActive())
        {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit()
                {
                    log.info(">> Transactional afterCommit...");
                    asyncProcAutoTaskService.doSendDelayTask(taskId, delayTime);
                }
            });
        }
        else
        {
            log.info(">> Transaction synchronization is not active");
            asyncProcAutoTaskService.doSendDelayTask(taskId, delayTime);

        }

    }


    public void afterCommit(Function function)
    {
        if (TransactionSynchronizationManager.isSynchronizationActive())
        {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit()
                {
                    log.info(">> Transactional afterCommit...");
                    try
                    {
                        function.apply();
                    }
                    catch (Exception e)
                    {
                        log.error(">> Transaction after commit process execute failure.", e);
                    }
                }
            });
        }
        else
        {
            log.info(">> Transaction synchronization is not active");
            try
            {
                function.apply();
            }
            catch (Exception e)
            {
                log.error(">> Transaction after commit process execute failure.", e);
            }
        }

    }


    public void afterCompletion(Function function)
    {
        if (TransactionSynchronizationManager.isSynchronizationActive())
        {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCompletion(int status)
                {
                    log.info(">> Transactional afterCompletion...");
                    try
                    {
                        function.apply();
                    }
                    catch (Exception e)
                    {
                        log.error(">> Transaction after completion process execute failure.", e);
                    }
                }
            });
        }
        else
        {
            log.info(">> Transaction synchronization is not active");
            try
            {
                function.apply();
            }
            catch (Exception e)
            {
                log.error(">> Transaction after commit process execute failure.", e);
            }
        }

    }

    @FunctionalInterface
    public interface Function
    {
        /**
         * Applies this function.
         *
         * @throws Exception e
         */
        void apply() throws Exception;
    }
}
