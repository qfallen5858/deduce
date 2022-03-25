package com.kanq.deduce.web.controllers;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

import com.kanq.deduce.web.vo.ApiResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandController {
    @Autowired
    private JmsMessagingTemplate jmsMessageTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @RequestMapping("/begin")
    public ApiResult begin(){
        return ApiResult.SUCCESS;
    }

    private void sendMessage(Destination destination, final String message){
        jmsMessageTemplate.convertAndSend(destination, message);
    }

    @RequestMapping("/send")
    public ApiResult sendQueue(){
        this.sendMessage(this.queue, "hello");
        return ApiResult.SUCCESS;
    }

    @RequestMapping("/topic")
    public ApiResult sendTopic(){
        this.sendMessage(this.topic, "test");
        return ApiResult.SUCCESS;
    }

}
