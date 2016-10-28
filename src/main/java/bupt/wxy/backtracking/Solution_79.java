package bupt.wxy.backtracking;

import java.util.Set;

/**
 * Created by xiyuanbupt on 10/28/16.
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class Solution_79 {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if(row == 0)return false;
        int col = board[0].length;
        if(col==0)return false;
        Character c = word.charAt(0);
        boolean[][] visited = new boolean[row][col];
        /**
         * 下面代码只是为了验证被初始化为false
        for(int i = 0;i<row;i++)
            for (int j = 0;j<col;j++)
                System.out.println(visited[i][j]);
         **/
        for(int i = 0;i<row;i++)
            for(int j = 0;j<col;j++){
                if(board[i][j] == c){
                    visited[i][j] = true;
                    if(exist(board,word.substring(1),i,j,visited)){
                        return true;
                    }else {
                        visited[i][j] = false;
                    }
                }
            }
        return false;
    }

    public boolean exist(char[][] board, String word, int x, int y,boolean[][] visited ){
        if(word.length()==0)return true;
        Character c = word.charAt(0);
        String newword = word.substring(1);
        // 上
        if(y-1>=0)
            if(!visited[x][y-1] &&board[x][y-1]==c) {
                visited[x][y-1] = true;
                if (exist(board, newword, x, y - 1, visited)) return true;
                else visited[x][y-1] = false;
            }
        // 下
        if(y+1<board[0].length)
            if(!visited[x][y+1] && board[x][y+1]==c) {
                visited[x][y+1] = true;
                if (exist(board, newword, x, y + 1, visited)) return true;
                else visited[x][y+1] = false;
            }
        // 左边
        if(x-1>=0)
            if(!visited[x-1][y] && board[x-1][y] == c) {
                visited[x-1][y]=true;
                if (exist(board, newword, x - 1, y, visited)) return true;
                else visited[x-1][y] = false;
            }

        // 右边
        if(x+1<board.length)
            if(!visited[x+1][y] &&board[x+1][y] == c) {
                visited[x+1][y] = true;
                if (exist(board, newword, x + 1, y, visited)) return true;
                else visited[x+1][y] = false;
            }
        //情况都不满足
        return false;
    }

    public static void main(String[] args){
        Solution_79 sl = new Solution_79();
        char[][] board = {{'a','b'}};
        sl.exist(board,"awa");
    }
}
