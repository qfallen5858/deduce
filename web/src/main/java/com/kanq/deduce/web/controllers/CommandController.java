package com.kanq.deduce.web.controllers;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

import com.kanq.deduce.web.service.PlayService;
import com.kanq.deduce.web.vo.ApiResult;
import com.kanq.deduce.web.vo.PlayVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "指令模块")
@RequestMapping("/command")
public class CommandController {
    @Autowired
    private JmsMessagingTemplate jmsMessageTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Autowired
    private PlayService playService;

    @ApiOperation("推演启动")
    @PostMapping("/{playId}/begin")
    public ApiResult<PlayVO> begin(@PathVariable Integer playId){
        return new ApiResult<>(playService.beginPlay(playId));
    }

    @ApiOperation("推演暂停")
    @PostMapping("/{playId}/pause")
    public ApiResult<PlayVO> pause(@PathVariable Integer playId){
        return new ApiResult<>(playService.pausePlay(playId));
    }

    @ApiOperation("推演结束")
    @PostMapping("/{playId}/stop")
    public ApiResult<PlayVO> stop(@PathVariable Integer playId){
        return new ApiResult<>(playService.stopPlay(playId));
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
