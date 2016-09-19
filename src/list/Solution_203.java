package list;

/**
 * Created by xiyuanbupt on 9/19/16.
 */
public class Solution_203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = new ListNode(0);
        curr.next = head;
        ListNode pre = curr;
        while (head!=null){
            if(head.val == val){
                pre.next = head.next;
                head = head.next;
            }else {
                head = head.next;
                pre = pre.next;
            }
        }
        return curr.next;
    }
}
