package main.java.bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 9/5/16.
 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 Example:
 n = 10, I pick 6.

 Return 6.
 */
public class Solution_374 {
    private int guess(int num){
        return num;
    }
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start<=end){
            int mid =  start +(-start+end)/2;
            int res = guess(mid);

            if(res ==  0)return mid;
            else if(res==-1)end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
}
