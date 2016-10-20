package bupt.wxy.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by xiyuanbupt on 10/20/16.
 Given a complete binary tree, count the number of nodes.

 Definition of a complete binary tree from Wikipedia:
 In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 Subscribe to see which companies asked this question
 */
public class Solution_222 {

    // 自己能够想到的办法是层序遍历
    // 增加对二叉树的性质可以减少一半的时间 m0 = m2 + 1
    // 有进步,但是依然超时
    // 下面层序遍历超时
    public int mycountNodes(TreeNode root) {
        if(root == null)return 0;
        int res = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            res ++;
            TreeNode node = queue.poll();
            if(node.left == null ){
                //m1 = 0 m2 = res - 1
                return res - 1 + res;

            }
            else if(node.right == null){
                return 2 * res;
            }else {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return res;
    }

    // 上述算法完全二叉树的性质利用的不充分
    // 满二叉树节点个数为  1 << h - 1
    public int countNodes(TreeNode root){
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h - 1 ? (1 << h) + countNodes(root.right):
                        (1 << h - 1) + countNodes(root.left);
    }

    int height(TreeNode root){
        return root == null ? -1:1 + height(root.left);
    }


    public static void main(String[] args){
        int h = 2;
        int n = 1 << h;
        h = 1 << n;
        System.out.println(n);
        System.out.println(h);
    }
}
