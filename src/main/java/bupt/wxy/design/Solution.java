package bupt.wxy.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by xiyuanbupt on 11/21/16.
 Shuffle a set of numbers without duplicates.

 Example:

 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();
 */


public class Solution{
    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] rand = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int r = (int) (Math.random() * (i+1));
            rand[i] = rand[r];
            rand[r] = nums[i];
        }
        return rand;
    }
}

class Solution_384 {

    List<Integer> list ;
    int[] ori;

    public Solution_384(int[] nums) {
        ori = nums;
        list = new ArrayList<>(nums.length);
        for(Integer num: nums){
            list.add(num);
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        list = new ArrayList<>(ori.length);
        for(Integer num :ori){
            list.add(num);
        }
        return ori;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(list, new Random(seed));
        int len = list.size();
        int [] res = new int[len];
        for(int i = 0;i<len;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
