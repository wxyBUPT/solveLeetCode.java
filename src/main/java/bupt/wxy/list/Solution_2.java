package bupt.wxy.list;


/**
 * Created by xiyuanbupt on 9/9/16.

 */
public class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(1);
        head.next = l1;
        ListNode l1_pre = head;
        int pre = 0;
        int tmp ;
        while (l1!=null&&l2!= null){
            tmp = pre;
            pre = (l1.val + l2.val + pre) /10;
            l1.val = (l1.val + l2.val + tmp)%10;
            l1_pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1!=null){
            tmp = pre;
            pre = (l1.val + pre)/10;
            l1.val = (l1.val + tmp)%10;
            l1_pre = l1;
            l1 = l1.next;
        }
        while (l2!=null){
            tmp = pre;
            pre = (l2.val + pre)/10;
            l2.val = (l2.val + tmp) % 10;
            l1_pre.next = l2;
            l1_pre = l2;
            l2 = l2.next;
        }
        if(pre!=0){
            l1_pre.next = new ListNode(pre);
        }
        return head.next;
    }
}
