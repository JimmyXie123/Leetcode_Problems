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
    private int curt = 1;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }
    
    private void helper(TreeNode node, int k){
        if(curt==k){
            res = node.val;
            return;
        }
        if(node==null){
            return;
        }
        curt++;
        helper(node.left, k);
        helper(node.right, k);
        
    }
}