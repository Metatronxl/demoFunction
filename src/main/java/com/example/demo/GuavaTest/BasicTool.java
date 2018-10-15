package com.example.demo.GuavaTest;

import com.google.common.base.Objects;

import java.util.Optional;

/**
 * @author lei.X
 * @date 2018/9/3
 */
public class BasicTool {


    public static void testFunction(){

        Integer test = new Integer(5);
        System.out.println(Objects.hashCode(test));

    }

    public static void main(String[] args) {
        testFunction();
    }

}
