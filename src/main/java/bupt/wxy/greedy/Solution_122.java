package bupt.wxy.greedy;

/**
 * Created by xiyuanbupt on 10/31/16.
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time
 (ie, you must sell the stock before you buy again).
 */
public class Solution_122 {

    // 使用贪心算法
    public int maxProfit(int[] prices) {
        return maxProfit(prices,0);
    }

    int maxProfit(int[] prices,int start){
        if(start>=prices.length)return 0;
        // 找到第一个买入点,i 为买入点
        int i = start;
        for(;i<prices.length-1;i++){
            if(prices[i+1]>prices[i])break;
        }
        // 如果股票一直在降价
        if(i==prices.length-1){
            return 0;
        }

        // 找到卖出点
        int j = i+1;
        for(;j<prices.length-1;j++){
            if(prices[j+1]<prices[j])break;
        }

        // 如果股票一直在涨价
        if(j==prices.length-1){
            return prices[j] - prices[i];
        }

        return prices[j] - prices[i] + maxProfit(prices,j+1);
    }
}
