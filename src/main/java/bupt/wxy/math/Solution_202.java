package main.java.bupt.wxy.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiyuanbupt on 9/21/16.
 */
public class Solution_202 {

    static Map<Integer,Integer> pow = new HashMap<>();
    static {
        pow.put(0,0);
        pow.put(1,1);
        pow.put(2,4);
        pow.put(3,9);
        pow.put(4,16);
        pow.put(5,25);
        pow.put(6,36);
        pow.put(7,49);
        pow.put(8,64);
        pow.put(9,81);
    }
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        int tmp = n;
        while (tmp!=1){
            if(visited.contains(tmp))return false;
            visited.add(tmp);
            tmp = convert(tmp);
        }
        return true;
    }

    private int convert(int i){
        int res = 0;
        while (i!=0){
            res += pow.get(i%10);
            i = i/10;
        }
        return res;
    }
}
