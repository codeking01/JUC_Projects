package com.codeking.day01;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiongjl
 * @since 2023/9/9  12:06
 */
@Slf4j(topic = "c.testDemo01")
public class testDemo01 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("烧水···");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            log.debug("洗茶壶·洗茶杯·烧水");
            try {
                Thread.sleep(2000);
                t1.join();
                log.debug("泡茶");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");;
        t1.start();
        t2.start();
    }
}
