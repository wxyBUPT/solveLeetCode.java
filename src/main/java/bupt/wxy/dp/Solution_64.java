package bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 9/19/16.
 * 因为只能向下和向右移动,所以比较简单
 */
public class Solution_64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m == 0)return 0;
        int n = grid[0].length;
        if(n==0)return 0;
        int[][] dis = new int[m][n];

        dis[0][0] = grid[0][0];
        for(int i = 1;i<n;i++){
            dis[0][i] = dis[0][i-1] + grid[0][i];
        }
        for(int i = 1;i<m;i++){
            dis[i][0] = dis[i-1][0] + grid[i][0];
        }
        for(int i = 1;i<m;i++)
            for(int j = 1;j<n;j++){
                dis[i][j] = Math.min(dis[i-1][j],dis[i][j-1]) + grid[i][j];
            }
        return dis[m-1][n-1];
    }

    public static void main(String[] args){
        Solution_64 sl = new Solution_64();
        int[][] grid = {
                {1,2,3},
                {4,5,6}
        };
        System.out.println(sl.minPathSum(grid));
    }
}
