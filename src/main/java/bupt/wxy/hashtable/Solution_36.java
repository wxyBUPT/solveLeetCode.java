package bupt.wxy.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyuanbupt on 9/22/16.
 */
public class Solution_36 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;++j){
                char num = board[i][j];
                if(num!='.'){
                    if(
                            !seen.add(num + "is seen in row" + i)||
                                    !seen.add(num + "is seen in column" + j)||
                                    !seen.add(num+"is seen in block" + i/3 + " " + j/3)
                            )return false;
                }
            }
        }
        return true;
    }
}
