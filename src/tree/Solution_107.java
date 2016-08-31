package tree;

import java.util.*;

/**
 * Created by xiyuanbupt on 8/31/16.
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
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
        Stack<List<Integer>> resStack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
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
            resStack.push(tmp);
            highLevel = thisLevel;
        }
        while(!resStack.empty()){
            result.add(resStack.pop());
        }
        return result;
    }
}
