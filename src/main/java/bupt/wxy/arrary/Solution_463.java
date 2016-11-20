package bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 11/20/16.
 You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 Example:

 [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

 Answer: 16
 Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class Solution_463 {

    public int islandPerimeter(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==1){
                    ans+=4;

                    // 上面
                    if(i>0 && grid[i-1][j]==1)ans--;
                    // 下面
                    if(i<m-1 && grid[i+1][j] == 1)ans--;
                    // 左面
                    if(j>0 && grid[i][j-1]==1)ans--;
                    // 右面
                    if(j<n-1 && grid[i][j+1]==1)ans--;
                }
            }
        }
        return ans;
    }
}
