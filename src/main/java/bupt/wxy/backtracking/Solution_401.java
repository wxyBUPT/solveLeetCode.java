package bupt.wxy.backtracking;

import java.util.*;

/**
 * Created by xiyuanbupt on 11/18/16.
 A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

 Each LED represents a zero or one, with the least significant bit on the right.

 For example, the above binary watch reads "3:25".

 Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 原题目位置在 https://leetcode.com/problems/binary-watch/
 */
public class Solution_401 {

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] hours = {8,4,2,1};
        int[] minutes = {32, 16, 8, 4, 2, 1};
        // 在小时中选择i个数,在分钟中选择j 个数
        for(int i = 0;i<=num;i++){
            int j = num - i;
            List<Integer> chose_hour = new ArrayList<>();
            List<Integer> chose_minute = new ArrayList<>();
            List<Integer> curr = new ArrayList<>();
            choseNumber(hours, 0, curr, chose_hour, i, 11);
            choseNumber(minutes, 0, curr, chose_minute, j, 59);
            for(Integer i_hour:chose_hour){
                for(Integer i_minute:chose_minute){
                    String s = i_hour + ":" + (i_minute < 10 ? "0" + i_minute:i_minute);
                    res.add(s);
                }
            }
        }
        return res;
    }

    void choseNumber(int[] nums, int index, List<Integer> curr, List<Integer> res, int n, int max){
        if(curr.size()==n){
            int sum = 0;
            for(Integer i:curr){
                sum+=i;
            }
            if(sum<=max)
                res.add(sum);
            return;
        }
        int len = nums.length;
        if(index==len)return;
        int num = nums[index++];
        // 选当前数
        List<Integer> choose = new ArrayList<>(curr);
        choose.add(num);
        choseNumber(nums, index, choose, res, n, max);
        List<Integer> unchoose = new ArrayList<>(curr);
        choseNumber(nums, index, unchoose, res, n, max);
    }

    public static void main(String[] args){
        Solution_401 sl = new Solution_401();
        List<String> res = sl.readBinaryWatch(1);
        for(String s : res){
            System.out.println(s);
        }
    }
}
