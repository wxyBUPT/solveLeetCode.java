package bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 10/8/16.
 */
public class Solution_292 {
    public boolean canWinNim(int n) {
        if(n < 4){
            return true;
        }
        boolean f1 = true;
        boolean f2 = true;
        boolean f3 = true;
        boolean ans = false;
        int i = 4;
        while (i<=n){
            i++;
            if(!f1||!f2||!f3){
                ans = true;
            }
            else {
                ans = false;
            }
            f1 = f2;
            f2 = f3;
            f3 = ans;
        }
        return ans;
    }

    public static void main(String[] args){
        Solution_292 sl = new Solution_292();
        boolean ans = sl.canWinNim(1199886170);
        System.out.println(ans);
    }

    /**
     * 上面的答案是错误的
     */
    public boolean ans(int n){
        return n%4 == 0;
    }
}
