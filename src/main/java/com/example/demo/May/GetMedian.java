package com.example.demo.May;

import java.util.stream.IntStream;

/**
 * @Author: ln
 * @Date: 2021/5/19 10:32
 * @Description:获取数组中的中间值，左边元素相加等于右边元素相加，如果没有返回-1
 */
public class GetMedian {
    /**
     *
     * @param nums
     * @return
     */
    public static int getMedian(int[] nums){
        //计算总值
        int total = IntStream.of(nums).sum();
        int left = 0;
        for (int i = 0; i < nums.length; i++){
            left += nums[i];
            if (left == total){
                return nums[i];
            }
            total -= nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15,2,3,1,1,10,5,4};
        System.out.println(getMedian(nums));
    }
}
