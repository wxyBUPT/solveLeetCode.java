package bupt.wxy.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyuanbupt on 10/23/16.
 */
public class Solution_437 {

    Set<TreeNode> visited = new HashSet<>();
    int target;

    public int pathSum(TreeNode root, int sum) {
        if(root==null)return 0;
        target = sum;
        return helper(root,sum,false);
    }

    private int helper(TreeNode root, int sum, boolean hasparent){
        if(root==null)return 0;
        if(sum==target && visited.contains(root)&&!hasparent)return 0;
        if(sum==target && !hasparent)visited.add(root);
        int count = (root.val==sum)?1:0;
        count+=helper(root.left,sum-root.val,true);
        count+=helper(root.right,sum-root.val,true);
        count += helper(root.left,target,false);
        count+=helper(root.right,target,false);
        return count;
    }

}
