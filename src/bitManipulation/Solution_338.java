package bitManipulation;

/**
 * Created by xiyuanbupt on 9/22/16.
 */
public class Solution_338 {

    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i = 0;i<num+1;i++){
            res[i] = helper(i);
        }
        return res;
    }

    private int helper(int n){
        int res = 0;
        for(int i = 0;i<32;i++){
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}
