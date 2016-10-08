package bupt.wxy.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiyuanbupt on 10/8/16.
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 */
public class Solution_60 {

    private static Map<Integer,Integer> map = new HashMap<>();
    static {
        map.put(0,1);
        for(int i = 1;i<10;i++){
            map.put(i,i * map.get(i-1));
        }
    }
    public String getPermutation(int n, int k) {
        k = k -1;
        StringBuilder sb  = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(i+1);
        }
        int i = n;
        while (i > 0){
            int index = k / map.get(i - 1);
            sb.append(list.remove(index));
            k = k%map.get(i-1);
            i--;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Solution_60 sl = new Solution_60();
        String ans = sl.getPermutation(3,2);
        System.out.println(ans);
    }
}
