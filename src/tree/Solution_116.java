package tree;

/**
 * Created by xiyuanbupt on 9/1/16.
 Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 有点类似于层序遍历
 * 但是本题还有另外的一种解法,即有一种规律
 * ......
 */
public class Solution_116 {
    public void connect(TreeLinkNode root) {
        if(root==null)return;
        List<TreeLinkNode> highLevel = new ArrayList<>();
        List<TreeLinkNode> thisLevel = new ArrayList<>();
        highLevel.add(root);
        while(highLevel.size()>0){
            thisLevel = new ArrayList<>();
            int len = highLevel.size();
            highLevel.add(null);
            for(int i = 0;i<len;i++){
                highLevel.get(i).next = highLevel.get(i+1);
                if(highLevel.get(i).left!=null)thisLevel.add(highLevel.get(i).left);
                if(highLevel.get(i).right!=null)thisLevel.add(highLevel.get(i).right);
            }
            highLevel = thisLevel;
        }
    }
}
