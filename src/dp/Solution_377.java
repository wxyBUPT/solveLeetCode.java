package dp;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 9/12/16.
 Given an integer array with all positive numbers and no duplicates,
 find the number of possible combinations that add up to a positive
 integer target.

 Example:

 nums = [1, 2, 3]
 target = 4

 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)

 Note that different sequences are counted as different combinations.

 Therefore the output is 7.

 */
public class Solution_377 {
    public int combinationSum4(int[] nums, int target) {
        if(nums.length==0)return 0;
        int[] dp = new int[target+1];
        Arrays.sort(nums);
        if(nums[0]>target)return 0;
        int i = 0;
        for(;i<nums[0];i++){
            dp[i] = 0;
        }
        dp[0] = 1;
        dp[i] = 1;
        i++;
        for(;i<=target;i++){
            int dp_i = 0;
            for(int j = 0;j<nums.length;j++){
                if(i-nums[j]>=0) {
                    dp_i = dp_i + dp[i - nums[j]];
                }
            }
            dp[i] = dp_i;
        }
        return dp[target];
    }

    public static void main(String[] args){
        Solution_377 sl = new Solution_377();
        int[] nums = {1,2,3};
        System.out.println(sl.combinationSum4(nums,4));
    }
}
