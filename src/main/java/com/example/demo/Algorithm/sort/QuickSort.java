package com.example.demo.Algorithm.sort;

import java.util.Arrays;

/**
 * @author lei.X
 * @date 2018/9/24
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {8, 2, 1, 4,6,7, 3, 5, 9, 6,11,19,13,55,67,32,22};

        quickSort(arr);
//        System.out.println(partSort(arr,0,arr.length-1));

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr){

        recurPartiton(arr,0,arr.length-1);

    }


    private static int partSort(int[] arr, int low ,int high){
        int base = arr[high];
        int cur = low;
        for(int i=low;i<high;i++){
            if (arr[i]<base){
                swap(arr,cur,i);
                cur++;
            }
        }
        swap(arr,high,cur);
        return cur;
    }

    private static void recurPartiton(int[] arr,int start,int end){
        if (end-start<1) return; //递归数组只剩一个元素
        int partition = partSort(arr,start,end);
        recurPartiton(arr,start,partition-1);
        recurPartiton(arr,partition+1,end);


    }


    public static void swap(int[] arr,int a,int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
