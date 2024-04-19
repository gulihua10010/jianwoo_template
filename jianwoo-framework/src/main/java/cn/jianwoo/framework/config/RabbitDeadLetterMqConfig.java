package cn.jianwoo.framework.config;

import cn.jianwoo.common.constant.Constants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 死信队列配置
 * 
 * @author gulihua
 * @date 2023-07-31 21:26
 */
@Configuration
public class RabbitDeadLetterMqConfig
{
    @Value("${mq.queue.dead_name}")
    private String name;

    // 创建死信的队列
    @Bean
    public Queue createDeadLetterQueue()
    {
        // queue（队列名，是否持久化）
        return new Queue(name, true);
    }


    // 创建死信的交换机
    @Bean
    public DirectExchange createDeadLetterExchange()
    {
        // DirectExchange（交换机名称，是否持久化，是否自动删除）
        return new DirectExchange(name + "_exchange", true, false);
    }


    // 队列和交换价绑定
    @Bean
    public Binding createDeadLetterBinding()
    {
        return BindingBuilder.bind(createDeadLetterQueue()).to(createDeadLetterExchange())
                // routing-key
                .with(Constants.DEAD_ROUTE);
    }
}
