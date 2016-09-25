package main.java.bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 9/12/16.
 Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include
 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence
 of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number.
 */
public class Solution_264 {

    /**
     * 挺简单的一道题让自己做的特别复杂
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if(n<=0)return n;
        if(n==1)return n;
        int[] result = new int[n];
        result[0] = 1;

        int poi1 = 0;
        int poi2 = 0;
        int poi3 = 0;
        int i = 1,min = 0;
        while (i<n){
            min = Math.min(result[poi1]*2,Math.min(result[poi2]*3,result[poi3]*5));
            if(min == result[poi1]*2)poi1++;
            if(min == result[poi2]*3)poi2++;
            if(min == result[poi3]*5)poi3++;
            result[i] = min;

            i++;
        }
        return result[n-1];
    }
    public static void  main(String[] args){
        Solution_264 sl = new Solution_264();
        sl.nthUglyNumber(10);
    }
}
