package cn.jianwoo.framework.config;

import cn.jianwoo.common.constant.Constants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 死信队列
 * 
 * @author gulihua
 * @date 2023-07-31 21:26
 */
@Configuration
public class RabbitDelayedQueue
{
    @Value("${mq.queue.delayed_name}")
    private String delayedName;

    @Value("${mq.queue.dead_name}")
    private String deadName;

    // 创建队列
    @Bean
    public Queue createDelayedQueue()
    {
        Map<String, Object> map = new HashMap<>();
        // 指定队列的死信队列的交换机
        map.put("x-dead-letter-exchange", deadName + "_exchange");
        // 指定死信接收队列绑定的routing-key
        map.put("x-dead-letter-routing-key", Constants.DEAD_ROUTE);
        return new Queue(delayedName, true,false,false, map);
    }


    // 创建交换机
    @Bean
    public DirectExchange createDelayedExchange()
    {
        // DirectExchange（交换机名称，是否持久化，是否自动删除）
        return new DirectExchange(delayedName + "_exchange", true, false);
    }


    // 队列和交换价绑定
    @Bean
    public Binding createDelayedBinding()
    {
        return BindingBuilder.bind(createDelayedQueue()).to(createDelayedExchange())
                // routing-key
                .with(Constants.DELAYED_ROUTE);
    }
}
