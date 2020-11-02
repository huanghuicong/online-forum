package com.web.onlineforumapi.demo;

import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;

public class SingletonDemo {

    private static volatile SingletonDemo singletonDemo;

    private SingletonDemo() {

    }

    public static SingletonDemo getInstance() {
        if (singletonDemo == null) {
            synchronized (SingletonDemo.class) {
                if (singletonDemo == null) {
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }


    public static void main(String[] args) {
        new Thread(() -> {
            SingletonDemo singletonDemo = SingletonDemo.getInstance();
            System.out.println(singletonDemo);
        }).start();

        new Thread(() -> {
            SingletonDemo singletonDemo1 = SingletonDemo.getInstance();
            System.out.println(singletonDemo1);
        }).start();

    }
}
