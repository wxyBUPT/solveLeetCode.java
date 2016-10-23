package bupt.wxy.twopoint;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S
 */


public class Solution_76 {


    public String minWindow(String s,String t){
        int i=0,j=0,I=0;
        int d = Integer.MAX_VALUE;
        int[] needs = new int[128];
        for(char c:t.toCharArray())needs[c]++;
        int counter = t.length();
        while (j<s.length()){
            if(needs[s.charAt(j++)] -- > 0)counter--;
            while (counter==0){
                if(j-i<d)d=j-(I=i);
                if(needs[s.charAt(i++)]++==0)counter++;
            }
        }
        return d == Integer.MAX_VALUE ? "":s.substring(I,I+d);

    }

    // 下面是自己想到的解决办法,但是和相当不好,好的算法不一定很长
    public String myminWindow(String s, String t) {
        Map<Character,Integer> tmap = new HashMap<>();
        for(Character c:t.toCharArray()){
            if(tmap.containsKey(c)){
                tmap.put(c,1 + tmap.get(c));
            }
            else {
                tmap.put(c,1);
            }
        }

        Set<Character> set = tmap.keySet();
        Map<Character,Integer> smap = new HashMap<>();
        for(Character c:s.toCharArray()){
            if(smap.containsKey(c)){
                smap.put(c,1+smap.get(c));
            }else {
                smap.put(c,1);
            }
        }

        for(Map.Entry<Character,Integer> entry:tmap.entrySet()){
            Integer count = smap.get(entry.getKey());
            if(count == null || count<entry.getValue())return "";
        }
        return minWindow(tmap,s,smap,new HashMap<String, String>());
    }


    private String minWindow(final Map<Character,Integer> tmap,final String s,final Map<Character,Integer> smap,Map<String,String> cache){
        // 判断是否满足基本条件
        if(cache.containsKey(s))return cache.get(s);
        Set<Character> set = tmap.keySet();
        int start = 0;int end = s.length() -1;
        while (start<end){
            Character cs = s.charAt(start);
            Character ce = s.charAt(end);
            while (!set.contains(cs) && start<end){
                start ++;
                cs = s.charAt(start);
            }
            while (!set.contains(ce) && start<end){
                end --;
                ce = s.charAt(end);
            }
            if(smap.get(cs) > tmap.get(cs) && smap.get(ce) > tmap.get(ce) && start<end){
                Map<Character,Integer> lmap = new HashMap<>(smap);
                lmap.put(cs,lmap.get(cs) -1);
                String sleft = s.substring(start+1,end+1);
                String left = minWindow(tmap,sleft,lmap,cache);

                Map<Character,Integer> rmap = new HashMap<>(smap);
                rmap.put(ce,rmap.get(ce) -1);
                String sright = s.substring(start,end);
                String right = minWindow(tmap,sright,rmap,cache);
                String res = left.length() < right.length() ? left:right;
                cache.put(s,res);
                return res;
            }
            if(smap.get(cs) > tmap.get(cs) ){
                start ++;
                smap.put(cs,smap.get(cs) -1);
            }else if (smap.get(ce) > tmap.get(ce)){
                end --;
                smap.put(ce,smap.get(ce) -1);
            }else {
                String res = s.substring(start,end + 1);
                cache.put(s,res);
                return res;
            }
        }
        String res = s.substring(start,end+1);
        cache.put(s,res);
        return res;
    }

    public static void main(String[] args){
        Solution_76 sl = new Solution_76();
        int[] needs = new int[128];
        for(char c:"abc".toCharArray()){
            needs[c]++;
        }
        for(int i:needs){
            System.out.println(i);
        }
    }
}
