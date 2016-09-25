package main.java.bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 8/31/16.
 Given a sorted array and a target value,
 return the index if the target is found.
 If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class Solution_35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        while (start<=end){
            mid = (start+end)/2;
            if(nums[mid]>target)end = mid-1;
            else if(nums[mid]<target)start = mid + 1;
            else return mid;
        }
        if(nums[mid]<target)return mid+1;
        return mid;
    }
}
