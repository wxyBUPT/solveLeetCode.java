package main.java.bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 8/30/16.
 *
 154. Find Minimum in Rotated Sorted Array II
 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.
 */
public class Solution_154 {

    /**
     * 本解法是利用递归,空间复杂度较高
     *
     * 如果想降低空间复杂度,遇到重复元素,可以跳过重复的元素
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return findMin(nums,start,end);
    }

    private int findMin(int[] nums ,int start , int end){
        if(start>end)return -1;
        if(start==end)return nums[start];
        if(start+1==end)return Math.min(nums[start],nums[end]);

        while(start<end-1){
            if(nums[start]<nums[end])return nums[start];

            int mid = start + (end-start)/2;
            if(nums[end]==nums[start]){
                if(nums[mid]>nums[end]) {
                    return findMin(nums, mid, end);
                }else if(nums[mid]<nums[end]){
                    return findMin(nums,start,mid);
                }else {
                    return Math.min(findMin(nums,start,mid),findMin(nums,mid,end));
                }
            }
            else {
                if(nums[mid]>=nums[start]){
                    start = mid;
                }else if(nums[mid]<=nums[end]){
                    end = mid;
                }else {
                    return -1;
                }
            }
        }

        return Math.min(nums[start],nums[end]);
    }

    public static void main(String[] args){
        Solution_154 solution_154 = new Solution_154();

        int[] nums = {10,1,10,10,10};

        int res = solution_154.findMin(nums);
        System.out.println(res);

    }
}
