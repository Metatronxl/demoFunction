package com.example.demo.chainFunction;

/**
 * @author lei.X
 * @date 2018/9/19
 */



public class Student {

    String name;
    String first;
    String last;
    int age;


    Student(){
        this.name = "xulei";
        this.age  = 19;
        this.first = "fir";
        this.last = "last";
    }

    public Student changeAge(int age){
        this.age = age;
        return this;
    }

    public Student changeName(String name){
        this.name = name;
        return this;
    }


    public static void main(String[] args) {
        /**
         * 链式调用
         */
        Student student = new Student().changeAge(25).changeName("liang");
        System.out.println(student.age);
        System.out.println(student.name);
    }

}
