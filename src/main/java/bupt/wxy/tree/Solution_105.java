package bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 10/28/16.
 Given preorder and inorder traversal of a tree, construct the binary tree.
 */
public class Solution_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    TreeNode buildTree(int[] preorder,int pstart,int pend,int[] inorder,int istart,int iend){
        if(pstart>pend)return null;
        TreeNode root = new TreeNode(preorder[pstart]);
        int index = istart;
        for(;index<=iend;index++){
            if(inorder[index] == preorder[pstart])
                break;
        }
        int llen = index - istart;

        root.left = buildTree(preorder,pstart+1,pstart+llen,inorder,istart,index-1);
        root.right = buildTree(preorder,pstart+llen+1,pend,inorder,index+1,iend);
        return root;
    }
}
