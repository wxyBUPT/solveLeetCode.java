package bupt.wxy.list;

/**
 * Created by xiyuanbupt on 9/5/16.
 Given a sorted linked main.java.bupt.wxy.list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class Solution_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        ListNode pre = head;
        ListNode currNode = head.next;
        while (currNode!=null){
            if(pre.val==currNode.val){
                pre.next = currNode.next;
            }
            else {
                pre = pre.next;
            }
            currNode = currNode.next;
        }
        return head;
    }
}
