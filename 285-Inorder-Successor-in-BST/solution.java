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
        TreeNode post = null;
        while(root!=null){
            if(root.val<p.val){
                root = root.right;
            }else if(root.val>p.val){
                post = root;
                root= root.left;
            }else{
                if(root.right!=null){
                    post = root.right;
                    while(post.left!=null){
                        post = post.left;
                    }
                }
                break;
            }
        }
        return post;
    }
}