package com.codeking.day01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xiongjl
 * @since 2023/9/8  23:11
 */
@Slf4j(topic = "c.testFutureTask")
public class testFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 实现Callable接口
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                log.debug("实现callable！！！");
                return "hello world";
            }
        };
        // 创建任务对象
        FutureTask<String> futureTask = new FutureTask<>(callable);
        // 创建线程
        Thread thread = new Thread(futureTask);
        // 启动线程
        thread.start();
        // 获取结果
        String s = futureTask.get();
        log.debug("s = {}", s);
    }
}
