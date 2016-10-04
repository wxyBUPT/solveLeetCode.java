package bupt.wxy.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xiyuanbupt on 9/22/16.
 */
public class Solution_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0)return 0;
        List<List<Integer>> res = new ArrayList<>(triangle.size());
        res.add(new ArrayList<>(triangle.get(0)));
        for(int i = 1;i<triangle.size();i++){
            List<Integer> hi = res.get(i-1);
            List<Integer> cu = triangle.get(i);
            List<Integer> lineRes = new ArrayList<>(cu.size());

            int len = cu.size() -1;
            /**
             * 处理第一个元素
             */
            lineRes.add(cu.get(0) + hi.get(0));
            for(int j = 1;j<len;j++){
                lineRes.add(cu.get(j) + Math.min(
                        hi.get(j-1),hi.get(j)
                ));
            }
            lineRes.add(cu.get(len) + hi.get(len-1));
            res.add(lineRes);
        }

        return Collections.min(res.get(triangle.size()-1));
    }
}
