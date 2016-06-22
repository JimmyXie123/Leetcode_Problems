/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private class ReturnType{
        int sum_self;
        int sum_lower;
        public ReturnType(int sum_self, int sum_lower){
            this.sum_self = sum_self;
            this.sum_lower = sum_lower;
        }
    }
    
    public int rob(TreeNode root) {
        ReturnType result = helper(root);
        return result.sum_self;
    }
    
    private ReturnType helper(TreeNode node){
        if(node==null){
            return new ReturnType(0, 0);
        }
        
       /* if(node.left==null&&node.right==null){
            return new ReturnType(node.val, 0);
        }
        */
        
        TreeNode left = node.left;
        TreeNode right = node.right;
        ReturnType leftReturn = helper(left);
        ReturnType rightReturn = helper(right);
        int sum_son = leftReturn.sum_self + rightReturn.sum_self;
        int sum_self = leftReturn.sum_lower + rightReturn.sum_lower+node.val;
        return new ReturnType(Math.max(sum_son, sum_self), sum_son);
    }
}