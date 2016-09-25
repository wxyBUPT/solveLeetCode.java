package main.java.bupt.wxy.list;

/**
 * Created by xiyuanbupt on 9/13/16.
 Given a singly linked main.java.bupt.wxy.list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */
public class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode tmp = head;
        int len = 0;
        while (tmp!=null){
            tmp = tmp.next;
            len ++;
        }
        int[] re = new int[len];
        tmp = head;
        int i = 0;
        while (tmp!=null){
            re[i++] = tmp.val;
            tmp = tmp.next;
        }
        int mid = len/2;
        for(i = 0;i<mid;i++){
            if(re[i]!=re[len-i-1])return false;
        }
        return  true;
    }
}
