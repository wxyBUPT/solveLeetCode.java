package main.java.bupt.wxy.string;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/21/16.
 */
public class Solution_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<=10)return new ArrayList<>();
        Map<String,Integer> fre = new HashMap<>();
        int len = s.length();
        for(int i = 0;i<=len -10;i++){
            String s1 = s.substring(i,10 + i);
            if(!fre.containsKey(s1)){
                fre.put(s1,1);
            }else {
                fre.put(s1,2);
            }
        }
        List<String> res = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: fre.entrySet()){
            if(entry.getValue()>1){
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
