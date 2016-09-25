package main.java.bupt.wxy.string;

/**
 * Created by xiyuanbupt on 9/9/16.
 Given a main.java.bupt.wxy.string S, find the longest palindromic substring in S.
 You may assume that the maximum length of S is 1000,
 and there exists one unique longest palindromic substring.
 */
public class Solution_5 {
    public String longestPalindrome(String s) {
        int max = Integer.MIN_VALUE;
        int start = Integer.MAX_VALUE,end = Integer.MIN_VALUE;
        int len = s.length();
        if(s.length() <= 1)return s;
        for(int i = 0;i<s.length();i++){
            int h = i,j = i;
            int currMax = 1;
            while (h >-1 && j < len && s.charAt(h) == s.charAt(j)){
                currMax += 2;
                h --;
                j ++;
            }
            currMax -=2;
            h++;
            j--;
            if(currMax>max){
                start = h;end = j;
                max = currMax;
            }
            h = i;
            j = i + 1;
            currMax = 2;
            while (h>-1 && j <len && s.charAt(h) == s.charAt(j)){
                currMax +=2;
                h--;
                j++;
            }
            currMax -=2;
            h++;
            j--;
            if(currMax>max){
                start = h;end = j;
                max = currMax;
            }
        }
        return s.substring(start,end + 1);
    }
}
