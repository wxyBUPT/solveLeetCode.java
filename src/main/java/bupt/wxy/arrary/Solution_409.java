package bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 10/28/16.
 Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Solution_409 {
    public int longestPalindrome(String s) {
        int[] dict = new int[128];
        System.out.println(dict[0]);
        for(int i = 0;i<s.length();i++){
            dict[s.charAt(i) - 'A'] ++;
        }
        int len = 0;
        boolean remain = false;
        for(int i = 0;i<128;i++){
            len += dict[i]/2;
            if(dict[i]%2 == 1){
                remain = true;
            }
        }
        return 2 * len + (remain?1:0);
    }

    public static void main(String[] args){
        Solution_409 sl = new Solution_409();
        sl.longestPalindrome("ss");
        for(int i = 0;i<52;i++){
            System.out.println((char)('A' + i));
        }
    }
}
