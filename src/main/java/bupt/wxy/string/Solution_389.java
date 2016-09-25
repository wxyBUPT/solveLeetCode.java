package main.java.bupt.wxy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 9/1/16.
 Given two strings s and t which consist of only lowercase letters.

 String t is generated by random shuffling main.java.bupt.wxy.string s and then add one more letter at a random position.

 Find the letter that was added in t.

 Example:

 Input:
 s = "abcd"
 t = "abcde"

 Output:
 e

 Explanation:
 'e' is the letter that was added.
 */
public class Solution_389 {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> table = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            Character c = s.charAt(i);
            if(!table.containsKey(c)){
                table.put(c,0);
            }
            Integer count = table.get(c);
            count++;
            table.put(c,count);
        }

        for(int i = 0;i<t.length();i++){
            Character c = t.charAt(i);
            if(table.containsKey(c)) {
                Integer count = table.get(c);
                count--;
                if (count < 0) return c;
                table.put(c, count);
            }else {
                return c;
            }
        }
        return 'c';
    }


}