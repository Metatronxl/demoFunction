package com.example.demo.Singleton;

/**
 * @author lei.X
 * @date 2018/10/21
 * 懒汉式的双重检验锁
 */
public class Singleton {


    /**
     * 使用volatile 是因为instance  = new Singleton（），而volatile可以禁止指令重排序优化
     */
    private volatile static Singleton instance;
    private Singleton(){};

    public static Singleton getSingleton(){
        if (instance == null){    //第一层检测
            synchronized (Singleton.class){   // synchronized block in Java
                if (instance == null){
                    instance = new Singleton();  //第二层检测
                }
            }
        }

        return instance;
    }


}
