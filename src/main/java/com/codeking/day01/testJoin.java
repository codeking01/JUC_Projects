package com.codeking.day01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xiongjl
 * @since 2023/9/9  10:27
 */
@Slf4j(topic = "c.testJoin")
public class testJoin {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 使用FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            log.debug("t1开始执行");
            Thread.sleep(2000);
            log.debug("t1执行结束");
            return 1;
        });
        Thread t1 = new Thread(futureTask, "t1");

        // 线程二
        FutureTask<Integer> futureTask1 = new FutureTask<>(() -> {
            log.debug("t2开始执行");
            Thread.sleep(2500);
            log.debug("t2执行结束");
            return 2;
        });
        Thread t2 = new Thread(futureTask1, "t2");
        t1.start();
        t2.start();
        t2.join(500);
        log.debug("main执行··");
        System.out.println("t1的结果：" + futureTask.get());
        System.out.println("t2的结果：" + futureTask1.get());
    }

}
