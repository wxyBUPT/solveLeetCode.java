package bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 10/5/16.
 */
public class Solution_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int curr = 1;
        int i = 0;
        int j = 0;
        int top = 0,left = 0,right = n-1,bot = n - 1;
        while (top <= bot && left<=right){
            while (j<=right){
                res[i][j++] = curr++;
            }
            j = right;
            i++;
            top ++;
            while (i<=bot){
                res[i++][j] = curr++;
            }
            right --;
            j--;
            i = bot;
            while (j>=left){
                res[i][j--]= curr++;
            }
            bot --;
            i--;
            j = left;
            while (i>=top){
                res[i--][j] = curr ++;
            }
            left ++;
            j++;
            i = top;
        }
        return res;
    }

    public static void main(String[] args){
        Solution_59 sl = new Solution_59();
        sl.generateMatrix(3);
    }
}
