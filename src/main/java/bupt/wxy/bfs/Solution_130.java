package bupt.wxy.bfs;


/**
 * Created by xiyuanbupt on 10/11/16.
 Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */
public class Solution_130 {

    public void solve(char[][] board) {
        int row = board.length;
        if(row==0)return;
        int col = board[0].length;
        for(int i = 0;i<row;i++)
            for(int j = 0;j<col;j++){
                if(board[i][j] == 'X') {
                    boolean bot = i + 1 >= row || board[i+1][j] == 'O';
                    boolean right = j+1 >=  col || board[i][j+1] == 'O';
                    if(!bot||!right) {
                        bfs(board, i, j);
                    }
                }
            }
    }

    void bfs(char[][] board,int i,int j){
        board[i][j] = 'O';
        // top
        if(i-1>=0 && board[i-1][j] == 'X')bfs(board,i-1,j);
        if(i+1<board.length && board[i+1][j] == 'X')bfs(board,i+1,j);
        if(j-1>=0 && board[i][j-1] == 'X')bfs(board,i,j-1);
        if(j+1<board[0].length && board[i][j+1] == 'X')bfs(board,i,j+1);
    }


}
