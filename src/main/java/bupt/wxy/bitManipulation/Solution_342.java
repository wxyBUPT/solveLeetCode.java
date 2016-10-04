package bupt.wxy.bitManipulation;

/**
 * Created by xiyuanbupt on 9/13/16.
 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.


 */
public class Solution_342 {
    static int a = 0xaaaaaaaa;
    public boolean isPowerOfFour(int num) {
        return num>0 && ((num&a) == 0) && ((num & (num-1))==0);
    }
}
