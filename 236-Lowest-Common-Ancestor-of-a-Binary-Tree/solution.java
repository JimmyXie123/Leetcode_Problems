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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root||q==root||p==q||root==null)  return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null&&right!=null){
            return right;
        }else if(left!=null&&right==null){
            return left;
        }else if(left!=null&&right!=null){
            return root;
        }else{
            return null;
        }
    }
}