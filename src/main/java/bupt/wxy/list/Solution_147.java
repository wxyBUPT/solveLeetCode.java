package bupt.wxy.list;

/**
 * Created by xiyuanbupt on 9/19/16.
 */
public class Solution_147 {

    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode headPre = new ListNode(Integer.MIN_VALUE);
        headPre.next = head;
        ListNode curr = head.next;
        ListNode tail = head;
        tail.next = null;
        while (curr!=null){
            ListNode tmp = curr;
            ListNode can = headPre;
            curr = curr.next;

            while (can.next != null && can.next.val < tmp.val){
                can = can.next;
            }

            tmp.next = can.next;
            can.next = tmp;

        }
        return headPre.next;
    }
}
