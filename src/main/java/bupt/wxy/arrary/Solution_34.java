package bupt.wxy.arrary;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 8/31/16.

 Given a sorted array of integers,
 find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int i = Arrays.binarySearch(nums,target);
        if(i<0){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }
        int start =i, end = i;
        while (nums[start] == target){
            start --;
            if(start<0)break;
        }
        start++;
        while (nums[end] == target){
            end ++;
            if(end==nums.length)break;
        }
        end--;
        ans[0]=start;
        ans[1]=end;
        return ans;
    }
}
