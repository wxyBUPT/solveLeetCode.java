package list;

/**
 * Created by xiyuanbupt on 9/5/16.

 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
public class Solution_141 {
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        /**
         * 这个节点的上个节点已经被访问
         */
        ListNode flag = new ListNode(1);
        ListNode curr = head;
        ListNode tmp ;
        while (curr!=null){
            if(curr.next == flag)return true;
            tmp = curr.next;
            curr.next = flag;
            curr = tmp;
        }
        return false;
    }
}
