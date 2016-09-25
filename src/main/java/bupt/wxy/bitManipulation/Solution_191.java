package main.java.bupt.wxy.bitManipulation;

/**
 * Created by xiyuanbupt on 8/31/16.

 Write a function that takes an unsigned integer and returns the
 number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has
 binary representation 00000000000000000000000000001011,
 so the function should return 3.

 */
public class Solution_191 {
    public int hammingWeight(long n){
        int result = 0;
        for(int i=0; i<32; i++){
            result += n&1;
            n >>= 1;
        }
        return result;
    }

    public static void main(String[] args){
        Solution_191 solution_191 = new Solution_191();
        System.out.println(solution_191.hammingWeight(  2147483648L ));
        System.out.println(10 & 1);
    }
}
