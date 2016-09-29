package bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 9/1/16.
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */

public class Solution_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)return null;
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums,int start,int end){
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        if(start<=mid-1)root.left = sortedArrayToBST(nums,start,mid-1);
        if(end>=mid+1)root.right = sortedArrayToBST(nums,mid+1,end);
        return root;
    }
}
