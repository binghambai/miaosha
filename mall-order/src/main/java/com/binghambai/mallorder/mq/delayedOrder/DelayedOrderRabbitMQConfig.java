package com.binghambai.mallorder.mq.delayedOrder;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayedOrderRabbitMQConfig {

    public static final String DELAYED_QUEUE_NAME = "delay.queue.order.delay.queue";

    public static final String DELAYED_EXCHANGE_NAME = "delay.queue.order.delay.exchange";

    public static final String DELAY_ROUTING_KEY = "delay.queue.order.delay.routing.key";

    @Bean
    public Queue immediateQueue() {
        return new Queue(DELAYED_QUEUE_NAME, true);
    }

    /**
     * 配置延时交换机
     * @return CustomExchange
     */
    @Bean
    public CustomExchange customExchange() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAYED_EXCHANGE_NAME, "x-delayed-message", true, false, args);
    }

    @Bean
    public Binding bindingNotify(@Qualifier("immediateQueue") Queue queue,
                                 @Qualifier("customExchange") CustomExchange customExchange) {
        return BindingBuilder.bind(queue).to(customExchange).with(DELAY_ROUTING_KEY).noargs();
    }
}
