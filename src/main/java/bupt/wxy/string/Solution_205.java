package bupt.wxy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 9/21/16.
 */
public class Solution_205 {

    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        Map<Character,Character> map1 = new HashMap<>();
        if(s.length() != t.length())return false;
        int len = s.length();
        Character c1;
        Character c2;
        for(int i = 0;i<len;i++){
            c1 = s.charAt(i);
            c2 = t.charAt(i);
            System.out.println(c1 + " " + c2);
            if(map.containsKey(c1) && !map1.containsKey(c2)){
                return false;
            }
            else if( !map.containsKey(c1) && map1.containsKey(c2)){
                return false;
            }else if(!map.containsKey(c1) && !map1.containsKey(c2)){
                map.put(c1,c2);
                map1.put(c2,c1);
            }else {
                if(map.get(c1)!=c2 || map1.get(c2)!=c1)return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Solution_205 sl = new Solution_205();
        sl.isIsomorphic("ab","aa");
    }
}
