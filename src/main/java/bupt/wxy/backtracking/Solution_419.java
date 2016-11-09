package bupt.wxy.backtracking;

/**
 * Created by xiyuanbupt on 11/9/16.
 Given an 2D board, count how many different battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:

 You receive a valid board, made of only battleships or empty slots.
 Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 Example:
 X..X
 ...X
 ...X
 In the above board there are 2 battleships.
 Invalid Example:
 ...X
 XXXX
 ...X
 This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 */
public class Solution_419 {

    public int countBattleships(char[][] board) {
        int row = board.length;
        if(row == 0)return 0;
        int col = board[0].length;

        int res = 0;
        for(int i = 0;i<row;i++)
            for(int j = 0;j<col;j++){
                if(board[i][j] == 'X'){
                    boolean top = i-1<0 || board[i-1][j] =='.';
                    boolean bot = i+1>=row || board[i+1][j] == '.';
                    if(top&&bot) {
                        res++;
                        while (j + 1 < col && board[i][j + 1] == 'X') j++;
                    }
                }
            }

        for(int i = 0;i<col;i++)
            for(int j = 0;j<row;j++){
                if(board[j][i]=='X'){
                    boolean left = i-1<0||board[j][i-1] == '.';
                    boolean right = i+1 >= col || board[j][i+1] == '.';
                    if(left&&right) {
                        res++;
                        while (j + 1 < row && board[j + 1][i] == 'X') j++;
                    }
                }
            }

        for(int i =0;i<row;i++)
            for(int j = 0;j<col;j++){
                if(board[i][j] == 'X') {
                    boolean top = i - 1 < 0 || board[i - 1][j] == '.';
                    if (!top) continue;
                    boolean bot = i + 1 >= row || board[i + 1][j] == '.';
                    if (!bot) continue;
                    boolean left = j - 1 < 0 || board[i][j - 1] == '.';
                    if (!left) continue;
                    boolean right = j + 1 >= col || board[i][j + 1] == '.';
                    if (!right) continue;
                    res--;
                }
            }
        return res;
    }

    public static void main(String[] args){
        Solution_419 sl = new Solution_419();
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        sl.countBattleships(board);
    }

}
