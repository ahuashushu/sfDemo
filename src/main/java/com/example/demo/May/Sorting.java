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

    /**
     * 希尔排序
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
     * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 按增量序列个数k，对序列进行k 趟排序；
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     *
     * 时间复杂度：O(n^1.3)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int[] shellSort(int[] nums){
        for (int temp = nums.length / 2; temp > 0; temp /= 2){
            for (int i = temp; i < nums.length; i++){
                int j = i;
                int current = nums[j];
                while (j - temp >= 0 && nums[j - temp] > current){
                    nums[j] = nums[j - temp];
                    nums[j - temp] = current;
                }
            }
        }
        return nums;
    }

    /**
     * 归并算法
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     *
     * 时间复杂度：O(nlog2n)
     * 空间复杂度：O(n)
     * @param nums
     */
    public static void mergeSort(int[] nums){
        mergeSortRange(nums,0,nums.length);
    }

    private static void mergeSortRange(int[] nums, int left, int right){
        if (right - left <= 1){
            return;
        }
        int mid = (left + right) / 2;
        mergeSortRange(nums, left , mid);
        mergeSortRange(nums, mid, right);
        merge(nums,left,mid,right);
    }

    private static void merge(int[] nums, int left, int mid, int right){
        int[] arry = new int[right - left];
        int leftHead = left;
        int rightHead = mid;
        int i = 0;
        while (leftHead < mid && rightHead < right){
            if (nums[leftHead] < nums[rightHead]){
                arry[i++] = nums[leftHead++];
            }else {
                arry[i++] = nums[rightHead++];
            }
        }
        while (leftHead < mid){
            arry[i++] = nums[leftHead++];
        }
        while (rightHead < right){
            arry[i++] = nums[rightHead++];
        }
        for (int j = 0; j < arry.length; j++){
            nums[left + j] = arry[j];
        }
    }

    public static void main(String[] args) {
        //冒泡
//        bubbleSort(new int[]{5,3,15,-9,0,3,1,62,24});
//        //选择
//        selectionSort(new int[]{5,3,15,-9,0,3,1,62,24});
//        //插入
//        insertionSort(new int[]{5,3,15,-9,0,3,1,62,24});
        //希尔
//        shellSort(new int[]{5,3,15,-9,0,3,1,62,24});
        //归并
        mergeSort(new int[]{5,3,15,-9,0,3,1,62,24});
    }
}
