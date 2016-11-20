package bupt.wxy.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 11/20/16.
 Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

 To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

 Example:

 Input:
 A = [ 1, 2]
 B = [-2,-1]
 C = [-1, 2]
 D = [ 0, 2]

 Output:
 2

 Explanation:
 The two tuples are:
 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class Solution_454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> sum_count = new HashMap<>();
        int len = A.length;
        for(int i = 0;i<len;i++){
            for(int j = 0;j<len;j++){
                int sum = A[i] + B[j] ;
                if(sum_count.containsKey(sum)){
                    sum_count.put(sum,sum_count.get(sum)+1);
                }else {
                    sum_count.put(sum,1);
                }
            }
        }

        int res = 0;
        for(int i = 0;i<len;i++){
            for(int j = 0;j<len;j++){
                int sum = C[i] + D[j];
                int key = 0-sum;
                if(sum_count.containsKey(key)){
                    res += sum_count.get(key);
                }
            }
        }
        return res;
    }
}
