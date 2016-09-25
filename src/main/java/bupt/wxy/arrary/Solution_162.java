package main.java.bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 8/31/16.

 A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1],
 find a peak element and return its index.

 The array may contain multiple peaks,
 in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1],
 3 is a peak element and your function should return the index number 2.
 */
public class Solution_162 {
    public int findPeakElement(int[] nums){
        if(nums.length<0)return -1;
        if(nums.length==1)return 0;
        if(nums[0]>nums[1])return 0;
        if(nums[nums.length-1]>nums[nums.length-2])return nums.length-1;
        int start = 1;
        int end = nums.length - 2;
        while(start<=end){
            int mid = (start + end)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])return mid;
            else if(nums[mid]>nums[mid-1])start = mid + 1;
            else end = mid -1;
        }
        return -1;
    }
}
