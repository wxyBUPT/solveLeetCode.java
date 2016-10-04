package bupt.wxy.dp;

/**
 * Created by xiyuanbupt on 9/12/16.
 Given a main.java.bupt.wxy.string s and a main.java.bupt.wxy.string t,
 check if s is subsequence of t.

 You may assume that there is only
 lower case English letters in both s and t.
 t is potentially a very long (length ~= 500,000) main.java.bupt.wxy.string,
 and s is a short main.java.bupt.wxy.string (<=100).

 A subsequence of a main.java.bupt.wxy.string is a new main.java.bupt.wxy.string which is
 formed from the original main.java.bupt.wxy.string by deleting some (can be none)
 of the characters without disturbing the relative positions of
 the remaining characters.
 (ie, "ace" is a subsequence of "abcde" while "aec" is not).

 Example 1:
 s = "abc", t = "ahbgdc"

 Return true.

 Example 2:
 s = "axc", t = "ahbgdc"

 Return false.
 */
public class Solution_392 {

    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)return true;
        Character c = s.charAt(0);
        int len = t.length();
        for(int i = 0;i<len;i++){
            if(t.charAt(i) == c){
                return isSubsequence(s.substring(1),t.substring(i+1));
            }
        }
        return false;
    }

    public boolean isSubsequence2(String s,String t){
        if(t.length()<s.length())return false;
        int pre = 0;
        for(int i = 0;i<s.length();i++){
            char tmpChar = s.charAt(i);
            pre = t.indexOf(tmpChar,pre);
            if(pre==-1)return false;
            pre++;
        }
        return true;
    }
}
