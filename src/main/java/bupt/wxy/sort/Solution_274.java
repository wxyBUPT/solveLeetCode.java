package bupt.wxy.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xiyuanbupt on 9/14/16.

 */
public class Solution_274 {
    public int hIndex(int[] citations) {
        if(citations.length==0)return 0;
        Arrays.sort(citations);
        int len = citations.length;
        int h = len;
        while (h > 0&& citations[len-h]<h ){
            h--;
        }
        return h;
    }

    public static void main(String[] args){
        Solution_274 sl = new Solution_274();
        int[] citations = {3, 0, 6, 1, 5};
        int res = sl.hIndex(citations);
        System.out.println(res);

    }
}
