package com.codeking.day01;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @author xiongjl
 * @since 2023/9/9  10:49
 * <p>
 * <p>
 * interrupt 打断线程
 * 打断 sleep 的线程, 会清空打断状态
 * 打断正常运行的线程, 不会清空打断状态
 * 打断park的线程, 不会清空打断状态
 */

@Slf4j(topic = "c.testInterrupt")
public class testInterrupt {
    public static void main(String[] args) throws InterruptedException {
        //testSleep();
        //test2();
        test3();
    }

    public static void testSleep() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        boolean interrupted = t1.isInterrupted();
        Thread.sleep(10);
        System.out.println("打断状态" + interrupted);
        t1.interrupt();
        System.out.println("打断状态" + t1.isInterrupted());
    }

    //打断正常的程序
    public static void test2() throws InterruptedException {
        Thread t2 = new Thread(() -> {
            while (true) {
                Thread thread = Thread.currentThread();
                boolean interrupted = thread.isInterrupted();
                log.debug("打断状态" + interrupted);
                if (interrupted) {
                    log.debug("打断状态" + interrupted);
                    break;
                }
            }

        }, "t2");
        t2.start();
        Thread.sleep(10);
        t2.interrupt();
        log.debug("打断状态" + t2.isInterrupted());
    }

    // park
    public static void test3() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            Thread thread = Thread.currentThread();
            LockSupport.park();
            boolean interrupted = thread.isInterrupted();
            log.debug("打断状态" + interrupted);
            if (interrupted) {
                log.debug("打断状态" + interrupted);
            }
        });
        thread1.start();
        Thread.sleep(10);
        thread1.interrupt();
        log.debug("打断状态" + thread1.isInterrupted());
    }
}

