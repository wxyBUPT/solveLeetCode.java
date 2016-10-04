package bupt.wxy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 9/13/16.
 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.
 */

public class Solution_242 {

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Integer> c_c = new HashMap<>();
        int len = s.length();
        for(int i = 0;i<len;i++){
            Character c = s.charAt(i);
            Integer count = c_c.get(c);
            if(count==null){
                count = 1;
            }else {
                count += 1;
            }
            c_c.put(c,count);
        }

        for(int i = 0;i<len;i++){
            Character c = t.charAt(i);
            Integer count = c_c.get(c);
            if(count == null)return false;
            count --;
            if(count<0)return false;
            c_c.put(c,count);
        }
        return true;
    }
}
