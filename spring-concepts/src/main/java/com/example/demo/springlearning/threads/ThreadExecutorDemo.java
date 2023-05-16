package com.example.demo.springlearning.threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadExecutorDemo {
    public static void main(String[] args) {
        List<Integer> buffer = new ArrayList<>(10);
        Producer p1 = new Producer(buffer, 10);
        Consumer c1 = new Consumer(buffer);
        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(c1);
        t2.start();
        Thread t3 = new Thread(c1);
        t3.start();

    }
}
