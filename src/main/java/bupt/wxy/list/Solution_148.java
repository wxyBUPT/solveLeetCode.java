package bupt.wxy.list;

import java.util.Arrays;

/**
 * Created by xiyuanbupt on 9/19/16.
 */
public class Solution_148 {

    /**
     * 下面算法使用了额外的空间
     * @param head
     * @return
     */
    public ListNode sortList1(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode curr = head;
        int size = 0;
        while (curr!=null){
            size++;
            curr = curr.next;
        }
        int[] nums = new int[size];
        curr = head;
        int i = 0;
        while (curr!=null){
            nums[i++] = curr.val;
            curr = curr.next;
        }
        Arrays.sort(nums);
        i = 0;
        curr = head;
        while (curr!=null){
            curr.val = nums[i++];
            curr = curr.next;
        }
        return head;
    }

    private ListNode merge(ListNode h1,ListNode h2){
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while (h1!=null&&h2!=null){
            if(h1.val<h2.val){
                curr.next = h1;
                curr = curr.next;
                h1 = h1.next;
            }else {
                curr.next = h2;
                curr = curr.next;
                h2 = h2.next;
            }
        }
        curr.next = h1==null?h2:h1;
        return pre.next;
    }

    public ListNode sortList(ListNode head){
        if(head == null || head.next == null)return head;

        /**
         * 将链表分为平均的两份
         */
        ListNode p1 = head,p2 = head,pre = head;
        while (p2!=null && p2.next!=null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        pre.next = null;

        ListNode h1 = sortList(head);
        ListNode h2 = sortList(p1);
        return merge(h1,h2);
    }

}
