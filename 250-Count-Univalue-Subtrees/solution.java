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
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null){
            return 0;
        }
        boolean tmp = isSame(root);
        return count;
    }
    
    private boolean isSame(TreeNode node){
        if(node.left==null&&node.right==null){
            count++;
            return true;
        }else if(node.left==null&&node.right!=null){
            boolean tmp = isSame(node.right);
            if(node.val==node.right.val&&tmp){
                count++;
                return true;
            }else{
                return false;
            }
        }else if(node.left!=null&&node.right==null){
            boolean tmp = isSame(node.left);
            if(node.val==node.left.val&&tmp){
                count++;
                return true;
            }else{
                return false;
            }
        }else{
            boolean left = isSame(node.left);
            boolean right = isSame(node.right);
            if(left&&right&&node.left.val==node.right.val&&node.left.val==node.val){
                count++;
                return true;
            }else{
                return false;
            }
        }
    }
}