package main.java.bupt.wxy.math;

/**
 * Created by xiyuanbupt on 9/21/16.
 */
public class Solution_204 {

    public int countPrimes(int n) {
        int count = 0;
        boolean[] f = new boolean[n];
        for (int i = 2; i < n; i++) {
            if(!f[i]){
                for (int j = 2; j*i < n; j++) {
                    f[j*i] = true;
                }
                count++;
            }
        }
        return count;
    }
}