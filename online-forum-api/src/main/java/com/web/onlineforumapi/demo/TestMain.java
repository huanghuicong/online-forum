package com.web.onlineforumapi.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestMain {
    public static void main(String[] args) {
        /*ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);
        reentrantLock.lock();
        reentrantLock.unlock();
        Lock lock = new ReentrantLock(true);
        lock.tryLock();
        lock.unlock();*/
        int sum = 0;
        int k = 80;
        for (int i = 0; i < 100; i++) {
            sum = sum + k;
            k = k + 5;
            if (k == 170) {
                break;
            }
        }
        System.out.println(sum);

    }
}
