package main.java.bupt.wxy.learn.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 9/18/16.
 */
public class LMap {
    public static void main(String[] args){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            entry.setValue(1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getValue());
        }

    }
}
