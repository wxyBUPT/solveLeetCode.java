package bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 9/12/16.
 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n.
 You have to guess which number I picked.

 Every time you guess wrong,
 I'll tell you whether the number I picked is higher or lower.

 However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

 Example:

 n = 10, I pick 8.

 First round:  You guess 5, I tell you that it's higher. You pay $5.
 Second round: You guess 7, I tell you that it's higher. You pay $7.
 Third round:  You guess 9, I tell you that it's lower. You pay $9.

 Game over. 8 is the number I picked.

 You end up paying $5 + $7 + $9 = $21.
 Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 */
public class Solution_375 {
    public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
        return DP(table,1,n);
    }

    int DP(int[][] t , int s,int e){
        if(s>=e)return 0;
        if(t[s][e]!=0)return t[s][e];
        int res = Integer.MAX_VALUE;
        for(int i = s;i<=e;i++){
            int var = i + Math.max(DP(t,s,i-1),DP(t,i+1,e));
            res = Math.min(res,var);
        }
        t[s][e] = res;
        return res;
    }

}
