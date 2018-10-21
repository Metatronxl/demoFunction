package com.example.demo.Singleton;

/**
 * @author lei.X
 * @date 2018/10/21
 * 静态内部类创建Singleton
 */
public class SingletonStatic {

    private static class SingletonHolder{ // 注意这里的内部类必须是私有的
        private static final SingletonStatic INSTANCE = new SingletonStatic();
    }

    private SingletonStatic(){}
    public static SingletonStatic getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
