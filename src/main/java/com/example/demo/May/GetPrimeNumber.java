package com.example.demo.May;

/**
 * @Author: ln
 * @Date: 2021/5/18 15:33
 * @Description:获取n以内的质数个数
 */
public class GetPrimeNumber {
    /**
     * 埃拉托斯特尼筛法
     * @param n
     * @return
     */
    public static int aiShaFa(int n){
        //默认false为质数
        boolean[] ifPrime = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i <= n; i++){
            if (!ifPrime[i]){
                count ++;
                for (int j = i * 2; j <= n; j += i) {
                    ifPrime[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 100000000;

        long start1 = System.currentTimeMillis();
        System.out.println(aiShaFa(n));
        long end2 = System.currentTimeMillis();
        System.out.println("code run cost :"+(end2-start1)+" ms");

    }
}
