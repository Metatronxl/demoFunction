package com.example.demo.Algorithm.sort;

import java.util.Arrays;

/**
 * @author lei.X
 * @date 2018/9/23
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {99, 5, 69, 33, 56, 13, 22, 55, 77, 48, 12, 88, 2,69,99};
        System.out.println("排序之前数组：");
        System.out.println(Arrays.toString(arr));
        //希尔排序
        insertionSort(arr);
        System.out.println("希尔排序后数组：");
        System.out.println(Arrays.toString(arr));

    }

    private static void  insertionSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        int len = arr.length;
        for(int d=len/2;d>0;d/=2){   // 决定子数组的大小（7 ，3， 1）
            for(int i=d;i<len;i++){  //第2个子分组所在的坐标
                for(int j=i-d;j>=0;j -=d){ //每一个子分组所在的坐标
                    if (arr[j] > arr[j+d]){   //这里一定要注意用j+d而不是用i来表示，因为i是一个不会变的值，而j+d会不断变化
                        swap(arr,j+d,j);
                        System.out.println(Arrays.toString(arr));
                    }
                }
            }
        }
    }

    /*
   发现无论什么排序。都需要对满足条件的元素进行位置置换。
   所以可以把这部分相同的代码提取出来，单独封装成一个函数。
   */
    public static void swap(int[] arr,int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
