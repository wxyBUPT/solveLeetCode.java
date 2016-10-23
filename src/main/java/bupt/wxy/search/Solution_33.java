package bupt.wxy.search;

/**
 * Created by xiyuanbupt on 10/23/16.
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */

public class Solution_33 {


    // 下面是使用自己的方法,有代码量更少的算法,判断条件更少,利用了循环移位
    public int search(int[] nums, int target) {
        if(nums.length==0)return -1;
        return binSerach(nums,target,0,nums.length-1);
    }

    private int binSerach(int[] nums,int target,int start,int end){
        int mid = start + (end - start)/2;
        if(nums[mid]==target)return mid;
        // 分为三种情况搜索
        if(nums[start] <= nums[mid] && nums[mid]<=nums[end]){
            if(nums[mid]<target && mid+1<=end){
                return binSerach(nums,target,mid+1,end);
            }
            if(nums[mid]>target && mid-1 >= start)return binSerach(nums,target,start,mid-1);
        }else if(nums[mid]>=nums[start] && nums[start]>=nums[end]){
            if(nums[mid]<target || target <= nums[end] && mid+1<=end)return binSerach(nums,target,mid+1,end);
            if(nums[mid]>target && target>=nums[start] && mid-1 >=start)return binSerach(nums,target,start,mid-1);
        }else if(nums[end]>=nums[mid] && nums[start]>=nums[end]){
            if(target>nums[mid] && target<=nums[end] && mid+1 <=end){
                return binSerach(nums,target,mid+1,end);
            }
            if(target < nums[mid] || target>=nums[start] && mid-1 >= start)return binSerach(nums,target,start,mid-1);
        }

        return -1;
    }

}
