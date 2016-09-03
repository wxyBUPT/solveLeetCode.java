package math;

/**
 * Created by xiyuanbupt on 9/3/16.
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */

public class Solution_7{
    public int reverse(int x){
        boolean isPos = x>0;
        if(!isPos)
            x = x* -1;
        int ans = 0;
        while(x>0){
            if( (ans) > (Integer.MAX_VALUE/10)) return 0;// overflows
            ans = ans* 10 + x % 10;
            x /=10;
        }
        return isPos? ans: -1*ans;
    }


    public static void main(String[] args){
        Solution_7 solution_7 = new Solution_7();
        System.out.println(solution_7.reverse(1));
    }
}


