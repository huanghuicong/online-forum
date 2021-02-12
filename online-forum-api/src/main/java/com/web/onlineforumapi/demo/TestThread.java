package com.web.onlineforumapi.demo;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

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

        ExecutorService executorService2 = new ThreadPoolExecutor(1, 1, 5, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(5));
        executorService2.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(11111);
            }
        });
        ReentrantLock rt = new ReentrantLock(true);
        rt.lock();
    }
}
