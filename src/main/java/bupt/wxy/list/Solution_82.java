package main.java.bupt.wxy.list;

/**
 * Created by xiyuanbupt on 9/19/16.
 */
public class Solution_82 {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)return head;

        ListNode headPre = new ListNode(Integer.MIN_VALUE);
        headPre.next = null;

        ListNode tail = headPre;

        ListNode curr = head;

        while (curr!=null){
            if(curr.next==null){
                tail.next = curr;
                tail = curr;
                curr = curr.next;
            }else if(curr.next.val != curr.val){
                tail.next = curr;
                curr = curr.next;
                tail = tail.next;
                tail.next = null;
            }else {
                curr = curr.next;
                while (curr != null && (curr.next == null || curr.next.val == curr.val)){
                    curr = curr.next;
                }
                if(curr!=null)curr = curr.next;
            }
        }
        return headPre.next;
    }
}
