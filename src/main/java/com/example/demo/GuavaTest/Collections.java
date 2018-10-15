package com.example.demo.GuavaTest;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lei.X
 * @date 2018/9/4
 */
public class Collections {

    public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of( "red",
            "orange", "yellow", "green", "blue", "purple");


    public static void main(String[] args) {

        ArrayList<Object> objects = Lists.newArrayList();

        String[] a = { "17", "52", "33", "412", "59", "62", "71" };
        List<String> list = Arrays.asList(a);

    }
}
