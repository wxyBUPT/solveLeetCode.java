package bupt.wxy.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiyuanbupt on 11/8/16.
 You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

 Given n, find the total number of full staircase rows that can be formed.

 n is a non-negative integer and fits within the range of a 32-bit signed integer.

 Example 1:

 n = 5

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤

 Because the 3rd row is incomplete, we return 2.
 Example 2:

 n = 8

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤ ¤
 ¤ ¤

 Because the 4th row is incomplete, we return 3.
 */
public class Solution_441 {

    static int sums;
    static {
        int max = Integer.MAX_VALUE - 1;

    }


    public int arrangeCoins(int n) {
        int i = 1;
        long sum = 1;
        while (sum<n){
            i++;
            // 在下面有溢出情况
            sum = i * (i+1)/2;
        }
        if(sum==n)return i;
        else return i-1;
    }
    public static void main(String[] args){
        Solution_441 sl = new Solution_441();
        int i = sl.arrangeCoins(1804289383);
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);
    }
}