package main.java.bupt.wxy.arrary;

/**
 * Created by xiyuanbupt on 9/13/16.
 Given an array of integers A and let n to be its length.

 Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

 F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

 Calculate the maximum value of F(0), F(1), ..., F(n-1).

 Note:
 n is guaranteed to be less than 105.

 Example:

 A = [4, 3, 2, 6]

 F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

 So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.

 */
public class Solution_396 {

    public int maxRotateFunction(int[] A) {
        if(A.length == 0){
            return 0;
        }

        int sum =0, iteration = 0, len = A.length;

        for(int i=0; i<len; i++){
            sum += A[i];
            iteration += (A[i] * i);
        }

        int max = iteration;
        for(int j=1; j<len; j++){
            // for next iteration lets remove one entry value of each entry and the prev 0 * k
            iteration = iteration - sum + A[j-1]*len;
            max = Math.max(max, iteration);
        }

        return max;
    }
}
