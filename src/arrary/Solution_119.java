package arrary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xiyuanbupt on 8/29/16.
 Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
public class Solution_119 {
    public List<Integer> getRow(int rowIndex) {
        /**
         * 用于保存上层结果
         * 并初始化第 0th
         */
        List<Integer> highterRow = new ArrayList<>(rowIndex);
        for(int i = 0;i<rowIndex;i++){
            highterRow.add(0);
        }
        /**
         * 当前行的结果
         * 并初始化
         */
        List<Integer> res = new ArrayList<>(rowIndex+1);
        for(int i = 0;i<rowIndex+1;i++){
            res.add(0);
        }
        res.set(0,1);
        if(rowIndex<0)return null;
        for(int i = 1;i<=rowIndex+1;i++){
            /**
             * 深拷贝
             */
            for(int j = 0;j<rowIndex;j++){
                highterRow.set(j,res.get(j));
            }
            res.set(0,1);
            res.set(i-1,1);
            for(int j = 1;j<i-1;j++){
                res.set(j,highterRow.get(j-1) + highterRow.get(j));
            }
        }

        return res;
    }

    public static void main(String[] args){
        Solution_119 solution_119 = new Solution_119();
        List<Integer> res = solution_119.getRow(3);
        System.out.println(res);
    }
}
