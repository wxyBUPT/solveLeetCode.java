package main.java.bupt.wxy.arrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 9/19/16.
 */
public class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null)return null;
        if(matrix.length ==0)return new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bot = m - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                System.out.println(matrix[top][i]);
                res.add(matrix[top][i]);
            }
            top += 1;
            if (top > bot) return res;

            for (int i = top; i <= bot; i++) {
                System.out.println(matrix[i][right]);
                res.add(matrix[i][right]);
            }
            right -= 1;
            if (right < left) return res;

            for (int i = right; i >= left; i--) {
                System.out.println(matrix[bot][i]);
                res.add(matrix[bot][i]);
            }
            bot -= 1;
            if (top > bot) return res;

            for (int i = bot; i >= top; i--) {
                System.out.println(matrix[i][left]);
                res.add(matrix[i][left]);
            }
            left += 1;
            if (right < left) return res;
        }
    }

    public static void main(String[] args){
        int[][] matrix = {
                {3},
                {2}
        };
        Solution_54 sl = new Solution_54();
        sl.spiralOrder(matrix);
    }
}
