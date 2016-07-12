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
    int res;
    TreeNode test;
    public int closestValue(TreeNode root, double target) {
        test = root;
        helper(root, target);
        return res;
    }
    
    private void helper(TreeNode node, double target){
        if(node==null){
            return;
        }
        if(node.val==target){
            res = node.val;
            return;
        }
        
        if(test==node){
            res = node.val;
        }else{
            if(Math.abs(node.val-target)<Math.abs(res-target)){
                res = node.val;
            }   
        }
        
        if(node.val<target){
            helper(node.right, target);
        }else{
            helper(node.left, target);
        }
    }
    
}