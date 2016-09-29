package bupt.wxy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiyuanbupt on 8/31/16.
 Given a binary main.java.bupt.wxy.tree,
 return the level order traversal of its nodes' values.
 (ie, from left to right, level by level).

 For example:
 Given binary main.java.bupt.wxy.tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]

 */
public class Solution_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> thisLevel;
        Queue<TreeNode> highLevel;
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
            result.add(tmp);
            highLevel = thisLevel;
        }
        return result;
    }
}
