package com.zlxy.boot.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SystemTimeTask {
    //以方法结束之后开始记时
//    @Scheduled(fixedDelay = 3000)
    //以方法开始时间开始记时
    // @Scheduled(fixedRate = 3000)
//    @Scheduled(cron = "")
    public void systemTimeTask(){
        System.out.println(new Date());
    }
}
