package com.example.demo.May;

/**
 * @Author: ln
 * @Date: 2021/5/26 16:37
 * @Description: 十大排序
 */
public class Sorting {
    /**
     * 冒泡
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     */
    public static int[] bubbleSort(int[] nums){
        for (int i = 0; i < nums.length -1; i++){
            for (int j = 0; j < nums.length - 1 - i; j++){
                if (nums[j] > nums[j + 1]){
                    int k = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = k;
                }
            }
        }
        return nums;
    }

    /**
     * 选择
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度: O(1)
     * @param nums
     * @return
     */
    public static int[] selectionSort(int[] nums){
        for (int i = 0; i < nums.length - 1; i++){
            int point = i;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] < nums[point]){
                    point = j;
                }
            }
            if (point != i){
                int k = nums[point];
                nums[point] = nums[i];
                nums[i] = k;
            }
        }
        return nums;
    }

    /**
     * 插入排序
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int[] insertionSort(int[] nums){
        for (int i = 1; i < nums.length; i++){
            int point = i - 1;
            int current = nums[i];
            while (point >= 0 && current < nums[point]){
                nums[point + 1] = nums[point];
                point--;
            }
            nums[point + 1] = current;
        }
        return nums;
    }

    public static void main(String[] args) {
        //冒泡
        bubbleSort(new int[]{5,3,15,-9,0,3,1,62,24});
        //选择
        selectionSort(new int[]{5,3,15,-9,0,3,1,62,24});
        //插入
        insertionSort(new int[]{5,3,15,-9,0,3,1,62,24});
    }
}
