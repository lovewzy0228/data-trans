package com.psbc.data.trans.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class scheduleTest {

    @Scheduled(cron = "0/5 * * * * ?") // 每5秒执行一次
    public void work() {
        System.out.println("Working...");
    }
}
