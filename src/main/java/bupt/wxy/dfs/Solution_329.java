package bupt.wxy.dfs;

/**
 * Created by xiyuanbupt on 10/28/16.
 Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:

 nums = [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]
 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:

 nums = [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]
 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
public class Solution_329 {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if(row == 0)return 0;
        int col = matrix[0].length;
        int res[][] = new int[row][col];
        for(int i = 0;i<row;i++)
            for(int j = 0;j<col;j++)
                res[i][j] = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<row;i++)
            for(int j = 0;j<col;j++)
                max = Math.max(longestIncreasingPath(matrix,i,j,res),max);
        return max;
    }

    private int longestIncreasingPath(int[][] matrix,int x,int y,int[][] res){
        if(res[x][y]!=0)return res[x][y];
        int tmp = 1;
        // 上
        if(y-1>=0)
            if(matrix[x][y-1]>matrix[x][y])
                tmp = 1 + longestIncreasingPath(matrix,x,y-1,res);

        // 下
        if(y+1<matrix[0].length)
            if(matrix[x][y+1]>matrix[x][y])
                tmp = Math.max(tmp,1+longestIncreasingPath(matrix,x,y+1,res));

        // 左
        if(x-1>=0)
            if(matrix[x-1][y] > matrix[x][y])
                tmp = Math.max(tmp,1+longestIncreasingPath(matrix,x-1,y,res));

        // 右
        if(x+1<matrix.length)
            if(matrix[x+1][y]>matrix[x][y])
                tmp = Math.max(tmp,1+longestIncreasingPath(matrix,x+1,y,res));

        res[x][y] = tmp;
        return tmp;
    }
}
