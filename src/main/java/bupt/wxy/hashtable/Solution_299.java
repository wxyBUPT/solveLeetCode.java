package main.java.bupt.wxy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 9/22/16.
 */
public class Solution_299 {
    public String getHint(String secret, String guess) {
        Map<Character,Integer> scharCount = new HashMap<>();
        Map<Character,Integer> gcharCount = new HashMap<>();
        int A = 0;
        int B = 0;
        for(int i = 0 ;i<secret.length();i++){
            Character a = secret.charAt(i);
            Character b = guess.charAt(i);
            if(a.equals(b)){
                A ++;
            }else {
                if(scharCount.containsKey(a)){
                    scharCount.put(a,scharCount.get(a) + 1);
                }else {
                    scharCount.put(a,1);
                }
                if(gcharCount.containsKey(b)){
                    gcharCount.put(b,gcharCount.get(b) + 1);
                }else {
                    gcharCount.put(b,1);
                }
            }
        }

        for(Map.Entry entry:scharCount.entrySet()){
            if(gcharCount.containsKey(entry.getKey())){
                B += Math.min((Integer)entry.getValue(),gcharCount.get(entry.getKey()));
            }
        }
        return A + "A" + B + "B";
    }

    public static void main(String[] args){
        Solution_299 sl = new Solution_299();
        System.out.println(sl.getHint("1807","7810"));
    }
}
