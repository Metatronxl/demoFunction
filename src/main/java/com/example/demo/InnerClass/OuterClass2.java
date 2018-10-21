package com.example.demo.InnerClass;

/**
 * @author lei.X
 * @date 2018/10/21
 */
public class OuterClass2 {

    private String str;

    public void outDisplay(){
        System.out.println("outclass...");
    }

    /**
     * 第一：成员内部类中不能存在任何static的变量和方法；
     * 第二：成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类。
     */
    public class InnerClass{

        private String anotherStr;  // 内部类也可以有自己的属性

        public void innerDisplay(){
            str = "test innerclass...";
            anotherStr = str + "test";
            System.out.println(str);
            System.out.println(anotherStr);
        }
    }


    public static void main(String[] args) {
        OuterClass2 outerClass = new OuterClass2();
        OuterClass2.InnerClass innerClass = outerClass.new InnerClass();

        innerClass.innerDisplay();
    }
}
