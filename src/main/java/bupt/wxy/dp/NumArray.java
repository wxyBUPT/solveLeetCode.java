package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 9/12/16.

 Given an integer array nums,
 find the sum of the elements between indices i and j (i ≤ j), inclusive.

 Example:
 Given nums = [-2, 0, 3, -5, 2, -1]

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 Note:
 You may assume that the array does not change.
 There are many calls to sumRange function.
 */
public class NumArray{

    int[] dp;

    public NumArray(int[] nums) {
        dp = new int[nums.length];
        if(dp.length==0)return;
        dp[0] = nums[0];
        for(int i = 1;i<nums.length;i++){
            dp[i] = dp[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i==0)return dp[j];
        else return dp[j] - dp[i-1];
    }
}
