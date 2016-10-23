package bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 10/23/16.
 Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

 Range Sum Query 2D
 The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

 Example:
 Given matrix = [
 [3, 0, 1, 4, 2],
 [5, 6, 3, 2, 1],
 [1, 2, 0, 1, 5],
 [4, 1, 0, 1, 7],
 [1, 0, 3, 0, 5]
 ]

 sumRegion(2, 1, 4, 3) -> 8
 sumRegion(1, 1, 2, 2) -> 11
 sumRegion(1, 2, 2, 4) -> 12
 */

// 高纬dp
public class NumMatrix {

    int[][] dp;

    public NumMatrix(int[][] matrix){
        int row = matrix.length;
        if(row==0)return;
        int col = matrix[0].length;
        dp = new int[row][col];

        dp[0][0] = matrix[0][0];
        for(int i = 1;i<col;i++){
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }
        for(int i = 1;i<row;i++){
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }

        for(int i = 1;i<row;i++)
            for(int j = 1;j<col;j++)
                dp[i][j] = matrix[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
    }

    public int sumRegion(int row1,int col1,int row2,int col2){
        if(row1==0&&col1==0)return dp[row2][col2];
        if(row1==0)return dp[row2][col2] - dp[row2][col1-1];
        if(col1==0)return dp[row2][col2] - dp[row1-1][col2];
        return dp[row2][col2] + dp[row1-1][col1-1] - dp[row1-1][col2] - dp[row2][col1-1];
    }


    /**
    int[][][][] dp;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        if(row==0)return;
        int col = matrix[0].length;

        int[][][][] dp = new int[row][col][row][col];
        dp[0][0][0][0] = matrix[0][0];
        for(int i = 1;i<col;i++){
            dp[0][0][0][i] = dp[0][0][0][i-1] + matrix[0][i-1];
        }
        for(int i = 1;i<row;i++){
            dp[0][0][i][0] = dp[0][0][i-1][0] + matrix[i-1][0];
        }
        for(int i = 1;i<row;i++)
            for(int j = 1;j<col;j++){
                dp[0][0][i][j] = dp[0][0][i-1][j] + dp[0][0][i][j-1] + matrix[i][j] - dp[0][0][i-1][j-1];
            }


    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[0][0][row2][col2] - dp[0][0][row1-1][col2] - dp[0][0][row2][col1-1] + dp[0][0]
    }
     **/
}
