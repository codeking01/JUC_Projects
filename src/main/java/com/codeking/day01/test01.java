package com.codeking.day01;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiongjl
 * @since 2023/9/5  21:42
 */
@Slf4j(topic = "c.test01")
public class test01 {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            log.debug("debug");
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        t1.start();
        log.debug("测试 ");
    }
}
