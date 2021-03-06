package bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 11/19/16.
 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 click to show follow up.

 Follow up:
 Did you use extra space?
 A straight forward solution using O(mn) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?
 */
public class Solution_73 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m==0)return;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j]==0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for(int i = 0;i<m;i++){
            if(rows[i]){
                for(int j = 0;j<n;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 0;j<n;j++){
            if(cols[j]){
                for(int i = 0;i<m;i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 还有另外一种方式是在首行保存状态

}
