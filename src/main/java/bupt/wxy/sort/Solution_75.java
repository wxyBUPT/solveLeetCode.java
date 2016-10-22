package bupt.wxy.sort;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 10/22/16.
 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class Solution_75 {

    // 使用快速排序
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length -1);
    }

    private void quickSort(int[] nums,int start,int end){
        int tmp = nums[start];
        int i = start;
        int j = end;
        while (i<j){
            while (nums[j]>tmp && i<j)j--;
            if(i<j) {
                nums[i++] = nums[j];
            }
            while (nums[i]<tmp && i<j)i++;
            if(i<j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = tmp;
        if(start<i-1)quickSort(nums,start,i-1);
        if(end>i+1)quickSort(nums,i+1,end);
    }

    // 简单的方法是直接使用库函数
    public void simplesortColors(int[] nums) {
        Arrays.sort(nums);
    }
}
