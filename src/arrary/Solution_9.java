package arrary;

/**
 * Created by xiyuanbupt on 8/30/16.
 Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Solution_9 {
    public boolean isPalindrome(int x){

        if(x < 0)return false;
        else if(x == 0 )return true;

        else {
            int tmp = x;
            int y = 0;
            while(x!=0){
                y = y * 10 + x%10;
                x = x/10;
            }
            if(y == tmp)return true;
            else return false;
        }
    }
}
