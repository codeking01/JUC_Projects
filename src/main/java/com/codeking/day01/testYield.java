package com.codeking.day01;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiongjl
 * @since 2023/9/9  11:56
 */
@Slf4j(topic =  "c.testYield")
public class testYield {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            log.info("start");
        }, "thread0");
        thread.start();
        thread.yield();
        Thread thread1 = new Thread(() -> {
            log.info("start");
        }, "thread1");
        thread1.start();
        log.info("end");
    }
}
