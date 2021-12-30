package com.binghambai.mallorder.controller;

import com.binghambai.mallorder.mq.DelayedRabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
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
public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg) {
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setExchange(DelayedRabbitMQConfig.DELAYED_EXCHANGE_NAME);
        rabbitTemplate.setRoutingKey(DelayedRabbitMQConfig.DELAY_ROUTING_KEY);
        rabbitTemplate.convertAndSend((Object) msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                MessageProperties messageProperties = message.getMessageProperties();
                messageProperties.setDelay(6000);
                messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message;
            }
        });
        log.info("发送时间:{} 发送消息：{} ", new Date(), msg);
    }
}
