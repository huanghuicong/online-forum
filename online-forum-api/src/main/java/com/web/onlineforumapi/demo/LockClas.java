package com.web.onlineforumapi.demo;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockClas {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        lock.tryLock();
        lock.unlock();
    }

    public void test() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    }
}
