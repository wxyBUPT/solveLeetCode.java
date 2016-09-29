package bupt.wxy.list;

/**
 * Created by xiyuanbupt on 9/5/16.
 Given a linked main.java.bupt.wxy.list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the main.java.bupt.wxy.list as 2->1->4->3.
 */
public class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null)return head;
        if(head.next==null)return head;
        /**
         * 添加表头节点
         */
        ListNode prePre = new ListNode(1);
        prePre.next = head;
        ListNode pre = head;
        ListNode next = head.next;
        ListNode tmp;
        head = head.next;
        while (pre!=null&&next!=null){
            tmp = next.next;
            next.next = pre;
            pre.next = tmp;
            prePre.next = next;
            prePre = pre;
            if(tmp==null){
                break;
            }
            pre = tmp;
            next = pre.next;
        }
        return head;
    }
}
