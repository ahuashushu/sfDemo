package com.example.demo.May;

import java.util.Arrays;

/**
 * @Author: ln
 * @Date: 2021/5/25 10:05
 * @Description: 628
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：6
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * 示例 3：
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 */
public class MaxiNumProduct {
    /**
     * 线性扫描
     * @param nums
     * @return
     */
    public static int maxiNumProduct(int[] nums){
        int min1 = Integer.MAX_VALUE, min2 = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int x : nums){
            if (x < min1){
                min2 = min1;
                min1 = x;
            }else if (x < min2){
                min2 = x;
            }

            if (x > max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if (x > max2){
                max3 = max2;
                max2 = x;
            }else if (x > max3){
                max3 = x;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    /**
     * 排序法
     * @return
     */
    public static int maxiNumProduct1(int[] nums){
        int len = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }
    public static void main(String[] args) {
        System.out.println(maxiNumProduct(new int[]{-1,-3,5,3,-2}));
        System.out.println(maxiNumProduct1(new int[]{-1,-3,5,3,-2}));
    }
}
