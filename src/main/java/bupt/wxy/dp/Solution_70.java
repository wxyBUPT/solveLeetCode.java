package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 9/11/16.
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps.
 In how many distinct ways can you climb to the top?
 */
public class Solution_70 {

    public int climbStairs(int n) {
        if(n<=0)return 0;
        else if(n==1)return 1;
        else if(n==2)return 2;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args){
        Solution_70 sl = new Solution_70();
        int n = sl.climbStairs(12);
        System.out.println(n);
    }
}
