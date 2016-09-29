package bupt.wxy.list;

/**
 * Created by xiyuanbupt on 9/5/16.
 Given a linked main.java.bupt.wxy.list, remove the nth node from the end of main.java.bupt.wxy.list and return its head.

 For example,

 Given linked main.java.bupt.wxy.list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked main.java.bupt.wxy.list becomes 1->2->3->5.
 */
public class Solution_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headPre = new ListNode(0);
        headPre.next = head;
        ListNode nThPre = headPre;
        ListNode curr = head;
        while(n>1){
            curr = curr.next;
            n--;
        }
        while (curr.next!=null){
            curr = curr.next;
            nThPre = nThPre.next;
        }
        nThPre.next = nThPre.next.next;
        return headPre.next;
    }
}
