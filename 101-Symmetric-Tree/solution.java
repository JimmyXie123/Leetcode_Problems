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
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    
    private boolean helper(TreeNode p, TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        
        if(p!=null&&q!=null&&p.val==q.val){
            return helper(p.left, q.right)&&helper(p.right, q.left);
        }
        
        return false;
    }
}