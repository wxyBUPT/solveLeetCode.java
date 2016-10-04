package bupt.wxy.arrary;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 9/10/16.
 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 */
public class Solution_36 {

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i<board.length;i++){

        }
        return false;
    }

    private boolean isValidSudoku(char[][] board,int i ,int j){
        boolean[] hasInt = new boolean[10];
        int val;
        Arrays.fill(hasInt,false);
        int iStart = i/3;
        int jStart = j/3;
        for(int k = 0;k<10;k++){
            if(board[i][k]!='.'){
                val = board[i][k] - '.';
                hasInt[val] = true;
            }
            if(board[k][j]!='.'){
                val = board[k][j] - '.';
                hasInt[val] = true;
            }
            if(board[iStart+k/3][jStart+k%3]!='.'){
                val = board[iStart+k/3][jStart+k%3] - '.';
                hasInt[val] = true;
            }
        }
        for(int k = 0;k<10;k++){
            if(hasInt[k]==false){
                board[i][j] = Character.toChars(k)[0];
            }
        }
        board[i][j] = '.';
        return false;
    }

    public static void main(String[] args){
        Character a = Character.toChars(1)[0];
        System.out.println(1);
        System.out.println(a);
    }

}
