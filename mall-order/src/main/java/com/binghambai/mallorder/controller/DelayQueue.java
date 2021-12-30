package com.binghambai.mallorder.controller;

import com.binghambai.mallorder.mq.DelayedRabbitMQConfig;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
@Slf4j
public class DelayQueue {

    @Autowired
    Producer producer;

    @GetMapping("/test/msg")
    public void send(@RequestParam("msg") String msg) {
        producer.sendMsg(msg);
    }
}
