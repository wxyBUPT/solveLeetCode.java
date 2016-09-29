package bupt.wxy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 9/29/16.
 */
public class Solution_95 {
    public List<TreeNode> generateTrees(int n) {
        if(n<=0)return new ArrayList<>();
        return generateTrees(1,n);
    }

    public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> res = new ArrayList<>();
        if(start==end){
            res.add(new TreeNode(start));
            return res;
        }
        if(start>end)return res;
        for(int i = start;i<=end;i++){
            if(i!=start&&i!=end){
                List<TreeNode> left = generateTrees(start,i-1);
                List<TreeNode> right = generateTrees(i+1,end);
                for(int j = 0;j<right.size();j++){
                    for(int k = 0;k<left.size();k++){
                        TreeNode treeNode = new TreeNode(i);
                        res.add(treeNode);
                        treeNode.right = right.get(j);
                        treeNode.left = left.get(k);
                    }
                }
            }
            else if(i==start){
                List<TreeNode> right = generateTrees(i + 1,end);
                int len = right.size();
                for(int j = 0;j<len;j++){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.right = right.get(j);
                    res.add(treeNode);
                }
            }
            else{
                List<TreeNode> left = generateTrees(start,i-1);
                int len = left.size();
                for(int j = 0;j<len;j++){
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left.get(j);
                    res.add(treeNode);
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        Solution_95 sl = new Solution_95();
        sl.generateTrees(3);
    }
}
