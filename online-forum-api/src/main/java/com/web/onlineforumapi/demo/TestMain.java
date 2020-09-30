package com.web.onlineforumapi.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestMain {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);
        reentrantLock.lock();
        reentrantLock.unlock();
        Lock lock = new ReentrantLock(true);
        lock.tryLock();
        lock.unlock();
    }
}
