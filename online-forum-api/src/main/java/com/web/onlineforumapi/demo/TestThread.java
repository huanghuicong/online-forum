package com.web.onlineforumapi.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestThread {
    public static void main(String[] args) {
        testThread();
    }


    public static void testThread () {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "runnable 方式");
            }
        }).start();

        Thread thread = new MyThread();
        thread.start();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程池方式-execute");
            }
        });

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        executorService1.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程池方式-submit");
            }
        });

    }
}
