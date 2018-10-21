package com.example.demo.Algorithm.DP;

/**
 * @author lei.X
 * @date 2018/10/15
 */


public class NpPackage {

    /**
     * 01背包问题
     * 有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。求解将哪些物品装入背包可使价值总和最大。
     *
     * 题目描述：
     * 假设山洞里共有a,b,c,d ,e这5件宝物（不是5种宝物），它们的重量分别是2,2,6,5,4，它们的价值分别是6,3,5,4,6，现在给你个承重为10的背包, 怎么装背包，可以才能带走最多的财富。
     *
     *
     * 解析：
     *
     * 使用1维数据时，需要从后往前来遍历，这样才能不重复使用元素
     * @param c
     * @param w
     * @param pack
     * @return
     */
    private int getPackageResult(int[] c, int[] w, int pack){
        int[] result = new int[pack+1];
        for(int i=0;i<pack;i++){
            result[i] = 0;
        }
        int len = c.length;
        for(int j=0;j<len;j++){
            for(int i=pack;i>0;i--){
                if (i>=c[j]){
                    result[i] = Math.max(result[i],result[i-c[j]]+w[j]);
                }
            }
        }


        return result[pack-1];
    }

    public static void main(String[] args) {

        int[] c = new int[]{2,2,6,5,4};
        int[] w = new int[]{6,3,5,4,6};

        int pack = 10;

        NpPackage solution = new NpPackage();

        int result = solution.getPackageResult(c,w,pack);
        System.out.println(result);

    }
}
