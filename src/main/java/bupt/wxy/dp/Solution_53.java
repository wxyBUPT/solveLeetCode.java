package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 9/12/16.
 Find the contiguous subarray within an array
 (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class Solution_53 {

    /**
     * 最大和的值得范围只有两种可能,一种是在中间
     * 另外一种是被拦腰截断
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums.length<=0)return 0;
        if(nums.length==1)return nums[0];
        int[] midMax = new int[nums.length];
        int[] max = new int[nums.length];
        midMax[0] = nums[0];
        max[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            midMax[i] = Math.max(nums[i],nums[i]+midMax[i-1]);
            max[i] = Math.max(max[i-1],midMax[i]);
        }
        return max[nums.length-1];
    }


}
