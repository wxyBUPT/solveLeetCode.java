package bupt.wxy.list;

/**
 * Created by xiyuanbupt on 9/29/16.
 * 列表反正 inplace
 */
public class Solution_92 {
    //
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)return head;
        ListNode headPre = new ListNode(0);
        headPre.next = head;
        ListNode pre = headPre;
        //tail 用来保存反转链表的结尾
        ListNode tail = head;
        int i = 1;
        while (i!=m){
            pre = tail;
            tail = tail.next;
            i++;
        }
        //start 用来保存反转链表的开始,不应该被改变
        ListNode start = tail;
        ListNode curr = tail.next;
        ListNode tmp;
        while (i!=n){
            tmp = curr.next;
            curr.next =start;
            start = curr;
            curr = tmp;
            i++;
        }
        pre.next = start;
        tail.next = curr;
        return headPre.next;
    }
}
