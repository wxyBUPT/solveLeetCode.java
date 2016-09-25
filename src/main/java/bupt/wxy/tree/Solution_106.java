package main.java.bupt.wxy.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiyuanbupt on 8/31/16.
 *
 Given inorder and postorder traversal of a main.java.bupt.wxy.tree,
 construct the binary main.java.bupt.wxy.tree.
 */
public class Solution_106 {

    private Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildTree(inorder,0,inorder.length-1,postorder,
                0,postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder,int istart,int iend,
                               int[] postorder,int pstart,int pend){
        if(istart>iend || pstart>pend)return null;
        int rootVal = postorder[pend];
        int iorIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = buildTree(inorder,iorIndex+1,iend,postorder,pend - (iend - iorIndex),pend-1);
        root.left = buildTree(inorder,istart,iorIndex-1,postorder,pstart,pend - iend + iorIndex -1);

        return root;
    }
}
