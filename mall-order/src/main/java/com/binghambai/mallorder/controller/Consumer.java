package com.binghambai.mallorder.controller;

import com.binghambai.mallorder.mq.DelayedRabbitMQConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.jni.Time;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactoryConfigurationUtils;
import org.springframework.jca.cci.connection.ConnectionFactoryUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = DelayedRabbitMQConfig.DELAYED_QUEUE_NAME)
    public void consumerMsg(@Payload Message msg, Channel channel) throws IOException {

        log.info("消费时间:{}, 消息内容:{}", new Date(), msg);
        //关闭自动应答
        channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
    }
}
