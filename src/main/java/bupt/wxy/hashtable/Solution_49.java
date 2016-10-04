package bupt.wxy.hashtable;

import java.util.*;

/**
 * Created by xiyuanbupt on 9/22/16.
 */
public class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            String key = sort(s);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else {
                map.put(key,new ArrayList<String>());
                map.get(key).add(s);
            }
        }

        List<List<String >> res = new ArrayList<>();
        for(Map.Entry<String,List<String >> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    private String sort(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args){
        Solution_49 sl = new Solution_49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String >> res = sl.groupAnagrams(strs);
        for(List<String > tmp : res){
            System.out.println("foo");
            System.out.println(tmp.toString());
        }
    }
}
