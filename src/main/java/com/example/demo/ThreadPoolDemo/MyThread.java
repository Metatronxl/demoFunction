package com.example.demo.ThreadPoolDemo;

/**
 * @author lei.X
 * @date 2018/8/17
 */
public class MyThread extends Thread {

    @Override
    public void run(){
        super.run();
        System.out.println(Thread.currentThread().getName()+"正在执行...");
    }


}
