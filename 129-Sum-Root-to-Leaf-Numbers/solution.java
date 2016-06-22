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
    private int result = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode node, int sum){
        if(node.left==null&&node.right==null){
            result += sum + node.val;
            return;
        }else{
            int pass = sum*10+node.val;
            helper(node.left, pass);
            helper(node.right, pass);
        }
    }
}