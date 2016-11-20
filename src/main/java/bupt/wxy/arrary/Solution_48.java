package bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 11/20/16.
 You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Follow up:
 Could you do this in-place?

 Subscribe to see which companies asked this question
 */
public class Solution_48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] tmp = new int[n][n];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                tmp[j][n-i-1] = matrix[i][j];
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = tmp[i][j];
            }
        }
    }
}
