package bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 11/12/16.
 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 For example, given the following matrix:

 1 0 1 0 0
 1 0 1 1 1
 1 1 1 1 1
 1 0 0 1 0
 */
public class Solution_221 {

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if(row==0)return 0;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        for(int i = 0;i<row;i++){
            dp[i][0] = matrix[i][0] == '1'?1:0;
            max = Math.max(max,dp[i][0]);
        }

        for(int j = 0;j<col;j++){
            dp[0][j] = matrix[0][j] == '1'?1:0;
            max = Math.max(max,dp[0][j]);
        }

        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                if(matrix[i][j]=='0'){
                    dp[i][j] = 0;
                    break;
                }
                int tmp = dp[i-1][j-1];
                if(tmp==0)dp[i][j] = 1;
                int min = 0;
                for(int k = 1;k<=tmp;k++){
                    if(matrix[i-k][j] == '1' && matrix[i][j-k] == '1'){
                        min = k;
                    }
                    else break;
                }
                dp[i][j] = min + 1;
                max = Math.max(dp[i][j],max);
            }
        }
        return max * max;
    }

    public static void main(String[] args){
        char[][] matrix = {
                "101001110".toCharArray(),
                "111000001".toCharArray(),
                "001100011".toCharArray(),
                "011001001".toCharArray(),
                "110110010".toCharArray(),
                "011111101".toCharArray(),
                "101110010".toCharArray(),
                "111010001".toCharArray(),
                "011110010".toCharArray(),
                "100111000".toCharArray()
        };
        Solution_221 sl = new Solution_221();
        int res = sl.maximalSquare(matrix);
        System.out.println(res);
    }
}
