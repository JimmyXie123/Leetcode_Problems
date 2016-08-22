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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null||p==null) return null;
        TreeNode prev = null;
        while(root!=null){
            if(root.val>p.val){
                prev = root;
                root = root.left;
            }else if(root.val<p.val){
                root = root.right;
            }else{
                if(root.right!=null){
                    prev = root.right;
                    while(prev.left!=null){
                        prev = prev.left;
                    }
                }
                break;
            }
        }
        return prev;
    }
}