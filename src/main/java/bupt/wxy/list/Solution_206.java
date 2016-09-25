package main.java.bupt.wxy.list;

/**
 * Created by xiyuanbupt on 9/5/16.
 Reverse a singly linked main.java.bupt.wxy.list.
 */
public class Solution_206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode headPre = new ListNode(0);
        headPre.next = head;
        ListNode curr = head.next;
        head.next = null;
        headPre.next = head;
        ListNode tmp;
        while (curr!=null){
            tmp = curr;
            curr = curr.next;
            tmp.next = headPre.next;
            headPre.next= tmp;
        }
        return headPre.next;
    }

    public static void main(String[] args){
        Solution_206 solution_206 = new Solution_206();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head = solution_206.reverseList(head);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
