package bupt.wxy.dfs;

/**
 * Created by xiyuanbupt on 11/20/16.

 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 11110
 11010
 11000
 00000
 Answer: 1

 Example 2:

 11000
 11000
 00100
 00011
 Answer: 3
 */
public class Solution_200 {

    public int numIslands(char[][] grid) {

        int m = grid.length;
        if(m==0)return 0;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(grid, visited, i, j);
                    ans ++;
                }
                visited[i][j] = true;
            }
        }
        return  ans;
    }

    void dfs(char[][] grid, boolean[][] visited, int row, int col){
        visited[row][col] = true;
        // 上
        if(row>0 && grid[row-1][col]=='1' && !visited[row-1][col]){
            dfs(grid,visited,row-1,col);
        }

        // 下
        if(row<grid.length-1 && grid[row+1][col]=='1'&&!visited[row+1][col]){
            dfs(grid,visited,row+1,col);
        }

        // 左边
        int n = grid[0].length;
        if(col>0 && grid[row][col-1]=='1' && !visited[row][col-1]){
            dfs(grid,visited,row,col-1);
        }

        if(col<n-1 && grid[row][col+1]=='1' && !visited[row][col+1]){
            dfs(grid,visited,row,col+1);
        }
    }


}
