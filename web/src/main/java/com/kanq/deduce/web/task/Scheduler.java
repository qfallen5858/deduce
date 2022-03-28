package com.kanq.deduce.web.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Scheduler {
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void testTasks(){
        log.info("定时任务执行时间：{}", sDateFormat.format(new Date()));
        //此处轮训处理待广播状态
    }
}
