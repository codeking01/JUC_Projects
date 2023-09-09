package com.codeking.day01;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiongjl
 * @since 2023/9/9  12:01
 */
@Slf4j(topic =  "c.testPriority")
public class testPriority {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("hello!");
        },"t1");
        t1.setPriority(Thread.MIN_PRIORITY);
        Thread  t2 = new Thread(() -> {
            log.debug("hello!");
        },"t2");
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        log.debug("main thread end");

    }
}
