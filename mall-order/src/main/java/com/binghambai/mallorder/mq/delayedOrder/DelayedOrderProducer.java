package com.binghambai.mallorder.mq.delayedOrder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class DelayedOrderProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final Integer ONE_MINUTE = 1000;

    public void sendMsg(Object msg, Integer minute) {
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setExchange(DelayedOrderRabbitMQConfig.DELAYED_EXCHANGE_NAME);
        rabbitTemplate.setRoutingKey(DelayedOrderRabbitMQConfig.DELAY_ROUTING_KEY);
        rabbitTemplate.convertAndSend(msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                MessageProperties messageProperties = message.getMessageProperties();
                messageProperties.setDelay(ONE_MINUTE * minute);
                messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message;
            }
        });
        log.info("发送时间:{} 发送消息：{} ", new Date(), msg);
    }
}
