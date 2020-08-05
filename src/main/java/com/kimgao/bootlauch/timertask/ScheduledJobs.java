package com.kimgao.bootlauch.timertask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledJobs {
  
    //表示方法执行完成后5秒再开始执行
    @Scheduled(fixedDelay=5000)
    public void fixedDelayJob() throws InterruptedException{
        System.out.println("fixedDelay 开始:" + new Date() + Thread.currentThread().getName());
        Thread.sleep(10 * 1000);
        System.out.println("fixedDelay 结束:" + new Date()  + Thread.currentThread().getName());
    }
    
    //表示每隔3秒
    @Scheduled(fixedRate=3000)
    public void fixedRateJob()throws InterruptedException{
        System.out.println("===========fixedRate 开始:" + new Date() + Thread.currentThread().getName());
        Thread.sleep(5 * 1000);
        System.out.println("===========fixedRate 结束:" + new Date() + Thread.currentThread().getName());
    }

    //表示每隔10秒执行一次
    @Scheduled(cron="0/10 * * * * ? ")
    public void cronJob(){
        System.out.println("=========================== ...>>cron...." + new Date() + Thread.currentThread().getName());
    }
}