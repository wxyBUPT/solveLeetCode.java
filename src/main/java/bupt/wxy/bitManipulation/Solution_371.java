package bupt.wxy.bitManipulation;

/**
 * Created by xiyuanbupt on 11/18/16.
 Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.
 */
public class Solution_371 {

    // 下面是如何实现加法的
    public int getSum(int a, int b) {
        if(a == 0)return b;
        if(b == 0)return a;

        while (b!=0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    // 下面是如何实现减法的
    public int getSubtract(int a, int b){
        while (b!=0){
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }
        return a;
    }

    // Recurisive 版本

    public int rgetSum(int a, int b){
        return (b==0) ? a:rgetSum(a^b, (a&b)<<1);
    }
}
