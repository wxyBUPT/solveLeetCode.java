package bupt.wxy.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xiyuanbupt on 11/22/16.
 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
 1            <---
 /   \
 2     3         <---
 \     \
 5     4       <---
 You should return [1, 3, 4].
 */
public class Solution_199 {

    // 使用层序遍历
    // 使用两个队列,一个队列存储层序遍历的节点,另外一个队列存储节点的层数
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)return res;
        TreeNode curr = root;
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> levelQueue = new ArrayDeque<>();
        nodeQueue.offer(curr);
        levelQueue.offer(0);
        while (!nodeQueue.isEmpty()){
            curr = nodeQueue.poll();
            int level = levelQueue.poll();
            if(levelQueue.isEmpty() || levelQueue.peek() > level){
                // 是当前层的最后一个节点
                res.add(curr.val);
            }
            if(curr.left!=null){
                nodeQueue.offer(curr.left);
                levelQueue.offer(level + 1);
            }
            if(curr.right != null){
                nodeQueue.offer(curr.right);
                levelQueue.offer(level + 1);
            }
        }
        return res;
    }
}
