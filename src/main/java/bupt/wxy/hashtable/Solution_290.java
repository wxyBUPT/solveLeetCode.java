package main.java.bupt.wxy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 9/22/16.
 */
public class Solution_290 {

    public boolean wordPattern(String pattern, String str) {

        Map<String,Character> s2c = new HashMap<>();
        Map<Character,String> c2s = new HashMap<>();

        String[] strs = str.split(" ");
        if(pattern.length()!=strs.length)return false;
        for(int i = 0;i<pattern.length();i++){
            boolean scc = s2c.containsKey(strs[i]);
            boolean ccs = c2s.containsKey(pattern.charAt(i));
            if(scc ^ ccs){
                return false;
            }else if(scc && ccs){
                if(!s2c.get(strs[i]).equals(pattern.charAt(i))){
                    return false;
                }
                if(!c2s.get(pattern.charAt(i)).equals(strs[i]))return false;
            }else {
                s2c.put(strs[i],pattern.charAt(i));
                c2s.put(pattern.charAt(i),strs[i]);
            }
        }
        return true;
    }
}
