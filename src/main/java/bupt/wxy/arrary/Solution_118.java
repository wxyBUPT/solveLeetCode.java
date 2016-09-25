package main.java.bupt.wxy.arrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 8/29/16.
 Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class Solution_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        /**
         * highterRow 用于保存上层的结果,并将第一层结果保存
         */
        if(numRows==0){
            return res;
        }
        List<Integer> highterRow = new ArrayList<>(1);
        highterRow.add(0,1);
        res.add(highterRow);
        for(int i = 2;i<=numRows;i++){
            /**
             * 本层的结果
             */
            List<Integer> thisRow = new ArrayList<>(i);
            for(int j =0;j<i;j++){
                thisRow.add(j,0);
            }
            /**
             * 初始化两个边界
             */
            thisRow.set(0,1);
            thisRow.set(i-1,1);

            for(int j = 1;j<i-1;j++){
                thisRow.set(j,highterRow.get(j-1)+highterRow.get(j));
            }
            res.add(thisRow);
            highterRow = thisRow;
        }
        return res;
    }

    public static void main(String[] args){
        Solution_118 solution_118 = new Solution_118();
        List<List<Integer>> res = solution_118.generate(3);
    }
}
