package bupt.wxy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 9/1/16.
 Given a binary main.java.bupt.wxy.tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary main.java.bupt.wxy.tree [1,2,2,3,4,4,3] is symmetric:

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
 1
 / \
 2   2
 \   \
 3    3
 */
public class Solution_101 {
    /**
     * 层序遍历,null 值放入
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        List<TreeNode> highLevel = new ArrayList<>();
        if(root.left==null&&root.right==null)return true;
        List<TreeNode> thisLevel ;
        highLevel.add(root.left);
        highLevel.add(root.right);
        while (highLevel.size()>0){
            int i = 0;
            int len = highLevel.size();
            int mid = len/2;
            thisLevel = new ArrayList<>();
            while(i<len){
                if(i<mid){
                    if(highLevel.get(i)==null || highLevel.get(len-1-i)==null){
                        if(highLevel.get(i)!=highLevel.get(len-1-i))return false;
                    }
                    else if (highLevel.get(i).val!=highLevel.get(len-1-i).val)
                        return false;
                }
                if(highLevel.get(i)!=null){
                    thisLevel.add(highLevel.get(i).left);
                    thisLevel.add(highLevel.get(i).right);
                }
                i++;
            }
            highLevel = thisLevel;
        }
        return true;
    }

    public static void main(String[] args){
        if(null == null){
            System.out.println("null equal ");

        }
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        if(a == b){
            System.out.println("node equal ");
        }

        if(a!=null){
            System.out.println("a!=null");
        }
    }

}
