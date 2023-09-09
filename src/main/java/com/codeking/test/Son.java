package com.codeking.test;

/**
 * @author xiongjl
 * @since 2023/9/8  22:45
 */

/**
 * 1. 子类在初始化时，先初始化父类，再初始化自身
 * 2. 父类在初始化时，先初始化成员变量，再初始化构造方法
 */
public class Son extends Father {
    private String name = "son";

    public Son() {
        print();
    }

    public void print() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        new Son();
    }
}

class Father {
    private String  name = "father";
    public   Father() {
        print();
    }

    public void print() {
        System.out.println(name);
    }
}
