package main.java.bupt.wxy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 9/1/16.
 Given a singly linked main.java.bupt.wxy.list where elements are
 sorted in ascending order, convert it to a height balanced BST.
 */
public class Solution_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)return null;
        List<ListNode> listNodes = new ArrayList<>();
        while(head!=null){
            listNodes.add(head);
            head = head.next;
        }
        return sortedListToBST(listNodes,0,listNodes.size()-1);
    }

    private TreeNode sortedListToBST(List<ListNode> listNodes,int start,int end){
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(listNodes.get(mid).val);
        if(start<=mid-1)root.left=sortedListToBST(listNodes,start,mid-1);
        if(end>=mid+1)root.right=sortedListToBST(listNodes,mid+1,end);
        return root;
    }
}
