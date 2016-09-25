package main.java.bupt.wxy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 9/13/16.
 Given a main.java.bupt.wxy.string, find the first non-repeating character in it and
 return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.
 */
public class Solution_387 {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int len = s.length();
        for(int i = 0;i<len;i++){
            Character c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }
            else {
                int count = map.get(c);
                count ++;
                map.put(c,count);
            }
        }

        for(int i = 0;i<len;i++){
            Character c = s.charAt(i);
            if(map.get(c)==1)return i;
        }
        return -1;
    }
}
