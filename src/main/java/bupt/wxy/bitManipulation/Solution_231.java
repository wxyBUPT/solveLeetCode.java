package main.java.bupt.wxy.bitManipulation;

/**
 * Created by xiyuanbupt on 8/31/16.

 Given an integer, write a function to determine if it is a power of two.
 */
public class Solution_231 {
    public boolean isPowerOfTwo(int n){
        if(n<=0)return false;
        while(n!=1){
            if(n%2==1)return false;
            n /=2;
        }
        return true;
    }
}
