package bupt.wxy.search;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 10/9/16.
 */
public class Solution_275 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int h = len;
        while (h > 0&& citations[len-h]<h ){
            h--;
        }
        return h;
    }

    public static void main(String[] args){
        Solution_275 sl = new Solution_275();
        int[] citations = {1};
        int ans = sl.hIndex(citations);
        System.out.println(ans);
    }
}
