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
    TreeNode last;
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        
        if(last!=null){
            last.left = null;
            last.right = root;
        }
        
        last = root;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        flatten(left);
        flatten(right);
        
    }
}