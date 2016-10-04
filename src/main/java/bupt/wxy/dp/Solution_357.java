package bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 9/12/16.
 Given a non-negative integer n,
 count all numbers with unique digits, x, where 0 ≤ x < 10n.

 Example:
 Given n = 2, return 91.
 (The answer should be the total numbers in the range of 0 ≤ x < 100,
 excluding [11,22,33,44,55,66,77,88,99])
 */

/**
 * 这个题有点排列组合的感觉
 */
public class Solution_357 {

    public int countNumbersWithUniqueDigits(int n) {
        if(n<=10)return 1;
        if(n>=11 )return 0;
        if(n == 1)return 10;
        int[] dp = new int[n+1];
        dp[2] = 91;
        for(int i = 3;i<=10 && i<=n;i++){
            dp[i] = dp[i-1] + chose_n(i);
        }
        return dp[n];
    }

    /**
     * 随意组成n位数,但是每一位数不可重复的数目,并且排除零开头的
     * @param n
     * @return
     */
    private int chose_n(int n){
        int[] dp = new int[n+1];
        for(int i = 11;i<=n;i++){
            dp[i] = 0;
        }
        dp[0] = 0;
        dp[1] = 9;
        for(int i = 2;i<=n&&i<=10;i++){
            dp[i] = dp[i-1]*(10 - i +1) ;
        }
        return dp[n];
    }
}

