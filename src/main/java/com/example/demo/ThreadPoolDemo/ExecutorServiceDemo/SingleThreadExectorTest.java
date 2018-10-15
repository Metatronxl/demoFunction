package com.example.demo.ThreadPoolDemo.ExecutorServiceDemo;

import com.example.demo.ThreadPoolDemo.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lei.X
 * @date 2018/8/17
 */
public class SingleThreadExectorTest {

    public static void main(String[] args) {

        // 永远只有一个线程在执行
        ExecutorService pool = Executors.newSingleThreadExecutor();

        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        pool.shutdown();



    }
}
