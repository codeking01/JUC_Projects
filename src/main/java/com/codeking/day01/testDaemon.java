package com.codeking.day01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author xiongjl
 * @since 2023/9/9  11:23
 *
 * 守护线程，我记得Linux有一个僵尸进程
 */
@Slf4j(topic ="c.testDaemon")
public class testDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            log.debug("starting");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("running");
            log.debug("ending");
        });
        thread.setDaemon(true);
        thread.start();
        log.debug("main over");
    }


}
