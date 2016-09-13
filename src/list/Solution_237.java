package list;

/**
 * Created by xiyuanbupt on 9/13/16.
 Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class Solution_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode next = node.next.next;
        ListNode pre = node;
        node = node.next;
        while (next!=null){
            pre = node;
            node.val = next.val;
            node = node.next;
            next = node.next;
        }
        pre.next = null;
    }
}
