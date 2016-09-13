package tree;

/**
 * Created by xiyuanbupt on 9/13/16.
 Given a non-negative integer num,
 repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2.
 Since 2 has only one digit, return it.
 */

public class Solution_258 {

    public int addDigits(int num) {
        while (num>=10){
            int tmp = 0;
            while (num!=0){
                tmp += num%10;
                num = num/10;
            }
            num = tmp;
        }
        return  num;
    }
}
