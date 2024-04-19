package cn.jianwoo.framework.config;

import cn.jianwoo.common.constant.QueueName;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author gulihua
 * @Description
 * @date 2023-07-31 21:26
 */
@Configuration
public class RabbitMqConfig
{
    @Value("${mq.queue.task_name}")
    private String name;
    @Bean
    public Queue simpleQueue()
    {
        return new Queue(name);
    }
}
