package bupt.wxy.sort;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 9/14/16.

 */
public class Solution_274 {
    public int hIndex(int[] citations) {
        if(citations.length==0)return 0;
        Arrays.sort(citations);
        int h = citations[citations.length -1];
        return h;
    }
}
