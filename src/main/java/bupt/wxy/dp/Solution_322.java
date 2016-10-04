package bupt.wxy.dp;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 10/4/16.
 */
public class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        Arrays.fill(res,-1);
        res[0] = 0;
        int len = coins.length;
        for(int curr = 1;curr <amount+1;curr++){
            for(int j = 0;j<len;j++){
                System.out.println(curr + " " + j + " " + coins[j]);
                if(curr - coins[j]>=0 && res[curr-coins[j]]!=-1){
                    if(res[curr]==-1)res[curr]= 1 + res[curr-coins[j]];
                    else {
                        res[curr] = Math.min(res[curr], 1 + res[curr - coins[j]]);
                    }
                }
            }
        }
        return res[amount];
    }

    public static void main(String[] args){
        Solution_322 sl = new Solution_322();
        int[] coins = {1};
        int res = sl.coinChange(coins,1);
        System.out.println(res);
    }
}
