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
    private int curt = 0;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }
    
    private void helper(TreeNode node, int k){
        if(node==null){
            return;
        }
        helper(node.left, k);
        curt++;
        if(curt==k){
            res = node.val;
            return;
        }
        helper(node.right, k);
        
    }
}