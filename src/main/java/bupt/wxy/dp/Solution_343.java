package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 9/12/16.
 Given a positive integer n,
 break it into the sum of at least two positive integers and
 maximize the product of those integers.
 Return the maximum product you can get.

 For example, given n = 2, return 1 (2 = 1 + 1);
 given n = 10, return 36 (10 = 3 + 3 + 4).

 Note: You may assume that n is not less than 2 and not larger than 58.

 Show Hint

 */
public class Solution_343 {

    private static int[] dp = new int[59];
    static {
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for(int i = 3;i<59;i++){
            int max = Integer.MIN_VALUE;
            for(int j = 1;j<i;j++){
                int tmp = Math.max(dp[j] * dp[i-j],j * (i-j));
                tmp = Math.max(tmp,dp[j] * (i-j));
                tmp = Math.max(tmp,j* dp[i-j]);
                max = max>tmp?max:tmp;
            }
            dp[i] = max;
        }
    }
    public int integerBreak(int n) {
        if(n<=1)return 0;
        return dp[n];
    }

    public static void main(String[] args){
        Solution_343 sl = new Solution_343();

    }
}
