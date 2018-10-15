package com.example.demo.Algorithm;
import com.google.common.base.Joiner;

import java.util.*;


/**
 * @author lei.X
 * @date 2018/9/8
 */




public class Solution {

    private Joiner pathJoiner = Joiner.on("/").skipNulls();

    public int nthUglyNumber(int n) {
        int[] uglyArray = new int[n];
        uglyArray[0] = 1;
        int element1 = 2,element2 = 3,element3 = 5;
        int count1 = 1, count2=1,count3 =1;

        int i=1;
        while (i<n){

            int miniNum = Math.min(element1, Math.min(element2, element3));
            if (miniNum != uglyArray[i-1]){
                uglyArray[i] = miniNum;
                i++;
            }
            if (miniNum == element1) {
                element1 = uglyArray[count1++]*2;
            }else if (miniNum == element2) {
                element2 = uglyArray[count2++]*3;
            }else {
                element3 = uglyArray[count3++]*5;
            }
        }


        return uglyArray[n-1];

    }

    private List<String> getParentDirAndCurrentDir(String fullPath){
        List<String> pathList = new ArrayList<>();

        List<String> str = Arrays.asList(fullPath.split("/"));
        str = new ArrayList<>(str);
        String currentName = str.get(str.size()-1); //当前目录的名字
        str.remove(str.size()-1); // 去掉当前目录
        String parentDirName = pathJoiner.join(str);
        pathList.add(currentName);
        pathList.add(parentDirName);

        return pathList;

    }



    public static void main(String[] args) {

        Solution solution = new Solution();



        System.out.println(solution.getParentDirAndCurrentDir("root/commonFile"));

    }
}
