package bupt.wxy.math;

/**
 * Created by xiyuanbupt on 9/13/16.
 Write a program to check whether a given number is an ugly number.

 Ugly numbers are positive numbers whose prime factors only
 include 2, 3, 5. For example, 6,
 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 */
public class Solution_263 {
    public boolean isUgly(int num) {
        if(num==0)return false;
        if(num==1)return true;
        while (num%2==0)num=num/2;
        while (num%3==0)num=num/3;
        while (num%5==0)num=num/5;
        if(num==1)return true;
        else return false;
    }
    public static void main(String[] args){
        Solution_263 sl = new Solution_263();
        sl.isUgly(2);
    }
}
