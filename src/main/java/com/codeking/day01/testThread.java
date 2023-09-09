package com.codeking.day01;

/**
 * @author xiongjl
 * @since 2023/9/8  22:56
 */
public class testThread {
    public static void main(String[] args) {
        // 继承实现 这个市非常不推荐的方式
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread run");
    }
}
