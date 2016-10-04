package bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 8/31/16.

 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity.
 Could you implement it using only constant extra space complexity?
 */
public class Solution_268 {
    public int missingNumber(int[] nums){
        int n = nums.length;
        int realSum = 0;
        for(int i = 0;i<nums.length;i++){
            realSum += nums[i];
        }
        int sum = n * (1+n) / 2;
        return sum - realSum;
    }
}
