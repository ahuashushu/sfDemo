package com.example.demo.May;

/**
 * @Author: ln
 * @Date: 2021/5/24 15:27
 * @Description: 69
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class MySqrt {
    /**
     * 二分查找法
     * @param x
     * @return
     */
    public static int mySqry(int x){
        int l = 0, r = x, ans = -1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (mid * mid <= x){
                ans = mid;
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqry(15));
    }
}
