package main.java.bupt.wxy.list;

/**
 * Created by xiyuanbupt on 9/18/16.
 Given a main.java.bupt.wxy.list, rotate the main.java.bupt.wxy.list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.


 */
public class Solution_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return null;
        ListNode tmp = head;

        int size = 0;
        while (tmp!=null){
            size++;
            tmp = tmp.next;
        }

        k = size - (k %size);
        if(k==0)return head;
        tmp = head;
        int[] nums = new int[size];
        int i = 0;
        while (tmp!=null){
            nums[i++] = tmp.val;
            tmp = tmp.next;
        }

        reverse(nums,0,k-1);
        reverse(nums,k,size-1);
        reverse(nums,0,size-1);
        tmp = head;
        i = 0;
        while (tmp!=null){
            tmp.val = nums[i++];
            tmp = tmp.next;
        }
        return head;
    }

    private void reverse(int[] nums,int start,int end){
        if(start>=end)return;
        int tmp;
        while (start<end){
            tmp = nums[end--];
            nums[end+1] = nums[start++];
            nums[start-1] = tmp;
        }
    }

    public ListNode aRight(ListNode head,int k){
        if(head == null || head.next == null )return head;
        ListNode tail = head;
        int len = 1;
        while (tail.next!=null){
            tail = tail.next;
            len++;
        }

        k = k%len;
        if(k==0)return head;
        tail.next = head;
        for(int i = 0;i<len-k;i++){
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }



}
