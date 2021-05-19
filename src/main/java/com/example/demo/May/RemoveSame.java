package com.example.demo.May;

/**
 * @Author: ln
 * @Date: 2021/5/19 9:55
 * @Description:去掉有序数组中重复元素后，返回新数组的个数
 * nums = [1,2,4,4]
 * 返回 3
 */
public class RemoveSame {
    /**
     * 双指针
     * @param nums
     * @return
     */
    public static int removeSame(int[] nums){
        if (nums.length <= 1){
            return nums.length;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++){
            if (nums[i] == nums[j]){
                continue;
            }
            nums[++i] = nums[j];
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,4,5,5};
        System.out.println(removeSame(nums));
    }
}
