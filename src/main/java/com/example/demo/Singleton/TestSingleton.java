package com.example.demo.Singleton;

/**
 * @author lei.X
 * @date 2018/10/21
 */
public class TestSingleton {


    public static void main(String[] args) {
        SingletonEnum test = SingletonEnum.getInstance();
        test.doSomething();

    }
}
