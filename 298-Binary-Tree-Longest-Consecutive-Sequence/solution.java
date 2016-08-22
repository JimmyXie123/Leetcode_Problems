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
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if(root==null)  return res;
        helper(root.left, root.val, 1);
        helper(root.right, root.val, 1);
        return res;
    }
    
    private void helper(TreeNode node, int num, int length){
        if(node==null){
            res = Math.max(res, length);
            return;
        }
        if(node.val==num+1){
            length++;
        }else{
            length=1;
        }
        res = Math.max(res, length);
        helper(node.left, node.val, length);
        helper(node.right, node.val, length);
    }
}