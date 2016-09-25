package main.java.bupt.wxy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiyuanbupt on 8/31/16.
 Given a binary main.java.bupt.wxy.tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

 For example:
 Given binary main.java.bupt.wxy.tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
 [15,7]
 ]

 */
public class Solution_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> thisLevel;
        Queue<TreeNode> highLevel;
        List<List<Integer>> result = new LinkedList<>();
        if(root == null)return result;
        highLevel = new LinkedList<>();
        highLevel.add(root);
        boolean isOrder = true;
        while(!highLevel.isEmpty()){
            List<Integer> tmp = new ArrayList<>(highLevel.size());
            thisLevel = new LinkedList<>();
            for(TreeNode treeNode:highLevel){
                if(isOrder)
                tmp.add(treeNode.val);
                else tmp.add(0,treeNode.val);
                if(treeNode.left!=null)thisLevel.add(treeNode.left);
                if(treeNode.right!=null)thisLevel.add(treeNode.right);
            }
            isOrder = !isOrder;
            result.add(tmp);
            highLevel = thisLevel;
        }
        return result;
    }
}
