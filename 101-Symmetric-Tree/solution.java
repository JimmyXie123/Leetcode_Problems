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
        if(root==null){
            return true;
        }
        return check(root.left, root.right);
    }
    
    private boolean check(TreeNode node1, TreeNode node2){
        if(node1==null&&node2==null){
            return true;
        }else if(node1==null||node2==null){
            return false;
        }else{
            if(node1.val==node2.val){
                return check(node1.left, node2.right)&&chech(node1.right, node2.left);
            }else{
                return false;
            }
        }
    }
}