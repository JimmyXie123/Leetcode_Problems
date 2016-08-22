/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class returnType{
    int rootSum;
    int childSum;
    public returnType(int rootSum, int childSum){
        this.rootSum = rootSum;
        this.childSum = childSum;
    }
}

public class Solution {
    public int rob(TreeNode root) {
        returnType res = helper(root);
        return Math.max(res.rootSum, res.childSum);
    }
    
    private returnType helper(TreeNode node){
        if(node==null)  return new returnType(0, 0);
        returnType left = helper(node.left);
        returnType right = helper(node.right);
        int tmp_root = left.childSum+right.childSum+node.val;
        int left_max = Math.max(left.rootSum, left.childSum);
        int right_max = Math.max(right.rootSum, right.childSum);
        int tmp_child = left_max+right_max;
        return new returnType(tmp_root, tmp_child);
    }
}