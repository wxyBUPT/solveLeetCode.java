package bupt.wxy.list;

/**
 * Created by xiyuanbupt on 9/5/16.
 Merge two sorted linked lists and return it as a new main.java.bupt.wxy.list.
 new main.java.bupt.wxy.list should be made by splicing together the nodes of the first two lists.
 */
public class Solution_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode headPre = new ListNode(0);
        ListNode pre = headPre;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        while (l1!=null){
            pre.next = l1;
            pre = l1;
            l1 = l1.next;
        }
        while (l2!=null){
            pre.next = l2;
            pre = l2;
            l2 = l2.next;
        }
        return headPre.next;
    }
}
