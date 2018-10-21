package com.example.demo.Singleton;

/**
 * @author lei.X
 * @date 2018/10/21
 *
 * 使用Enum来创建单例
 * 配合接口来实现功能
 */


public enum  SingletonEnum implements MySingleton{
    INSTANCE{
        @Override
        public void doSomething() {
            System.out.println("complete singleton");
        }
    };

    public static SingletonEnum getInstance(){
        return SingletonEnum.INSTANCE;
    }
}
