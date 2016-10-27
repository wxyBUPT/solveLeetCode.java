package bupt.wxy.dp;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 10/26/16.
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

 Note:
 Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤ 14,000.

 Examples:

 Input:
 nums = [7,2,5,10,8]
 m = 2

 Output:
 18

 Explanation:
 There are four ways to split nums into two subarrays.
 The best way is to split it into [7,2,5] and [10,8],
 where the largest sum among the two subarrays is only 18.
 */
public class Solution_410 {

    // 使用二分答案
    // 我终于懂了二分答案的含义了
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;long sum = 0;
        for(int num:nums){
            max = Math.max(num,max);
            sum += num;
        }
        if(m==1)return (int)sum;
        long l = max;
        long r = sum;
        while (l<=r){
            long mid = (l + r)/2;
            if(valid(mid,nums,m)){
                r = mid -1;
            }else {
                l = mid +1;
            }
        }
        return (int)l;
    }

    boolean valid(long target,int[] nums,int m){
        int count = 1;
        long total = 0;
        for(int num:nums){
            total += num;
            if(total>target){
                total = num;
                count++;
                if(count>m){
                    return false;
                }
            }
        }
        return true;
    }

}
