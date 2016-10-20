package bupt.wxy.bfs;


/**
 * Created by xiyuanbupt on 10/11/16.
 */
public class Solution_130 {

    public void solve(char[][] board) {
        if(board.length==0)return;
        int h = board.length;
        int w = board[0].length;
        boolean[][] change = new boolean[h][w];

        for(int i = 0;i<h;i++){
            for(int j = 0;j<w;j++){
                System.out.println(change[i][j]);
            }
        }
    }

    public static void main(String[] args){
        Solution_130 sl = new Solution_130();
        char[][] a = {{1,2},{2,3}};
        sl.solve(a);
    }
}
