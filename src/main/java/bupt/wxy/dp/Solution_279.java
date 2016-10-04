package bupt.wxy.dp;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 10/4/16.
 */
public class Solution_279 {
    public int numSquares(int n) {
        double t = Math.sqrt(n);
        int len_1 = (int)Math.ceil(t) + 1;
        int[] dict = new int[len_1];
        for(int i = 0;i<len_1;i++){
            dict[i] = i*i;
        }

        int[] res = new int[n+1];
        Arrays.fill(res,-1);
        res[0] = 0;
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<len_1;j++){
                if(i-dict[j]>=0){
                    if(res[i]==-1)res[i] = res[i-dict[j]] + 1;
                    else {
                        res[i] = Math.min(res[i],1+res[i-dict[j]]);
                    }
                }
            }
            System.out.println(i + " " + res[i]);
        }
        return res[n];
    }

    public static void main(String[] args){
        Solution_279 sl = new Solution_279();
        int res = sl.numSquares(1);
        System.out.println(res);
    }
}
