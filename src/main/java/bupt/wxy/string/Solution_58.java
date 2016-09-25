package main.java.bupt.wxy.string;

/**
 * Created by xiyuanbupt on 9/11/16.
 Given a main.java.bupt.wxy.string s consists of upper/lower-case alphabets and
 empty space characters ' ',
 return the length of last word in the main.java.bupt.wxy.string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of
 non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 */
public class Solution_58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int index = s.lastIndexOf(" ");
        s = s.substring(index+1,s.length());
        return s.length();
    }
}
