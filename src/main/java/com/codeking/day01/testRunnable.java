package com.codeking.day01;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xiongjl
 * @since 2023/9/8  23:01
 */

/**
 * 推荐使用组合的方式去做，配合Thread类
 * 实现Runnable接口,配合Thread类
 * @FunctionalInterface 这个代表函数式接口
 */
@Slf4j(topic = "c.testRunnable")
public class testRunnable {
    public static void main(String[] args) {
        // 实现RUnnable接口,配合Thread类
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug("Thread Name: {}", Thread.currentThread().getName());
                System.out.println("Hello World,这个是我的任务！！！");
            }
        };
        Thread thread = new Thread(task, "MyThread");
        thread.start();
        // lambda实现
        Runnable task1 = ()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("Thread Name: {}", Thread.currentThread().getName());
            System.out.println("Hello World,这个是我的任务！！！");
        };
        Thread thread1 = new Thread(task1, "MyThread1");
        thread1.start();
        log.debug("main over");
    }


}
