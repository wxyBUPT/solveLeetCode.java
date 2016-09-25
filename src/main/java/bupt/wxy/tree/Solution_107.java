package main.java.bupt.wxy.tree;

import java.util.*;

/**
 * Created by xiyuanbupt on 8/31/16.
 Given a binary main.java.bupt.wxy.tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary main.java.bupt.wxy.tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> thisLevel;
        Queue<TreeNode> highLevel;
        List<List<Integer>> result = new LinkedList<>();
        if(root == null)return result;
        highLevel = new LinkedList<>();
        highLevel.add(root);
        while(!highLevel.isEmpty()){
            List<Integer> tmp = new ArrayList<>(highLevel.size());
            thisLevel = new LinkedList<>();
            for(TreeNode treeNode:highLevel){
                tmp.add(treeNode.val);
                if(treeNode.left!=null)thisLevel.add(treeNode.left);
                if(treeNode.right!=null)thisLevel.add(treeNode.right);
            }
            result.add(0,tmp);
            highLevel = thisLevel;
        }
        return result;
    }
}
