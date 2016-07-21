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
    int sum = 0;
    public int longestConsecutive(TreeNode root) {
        int tmp = helper(root);
        return sum;
    }
    
    private int helper(TreeNode node){
        int res = 1;
        if(node==null){
            return 0;
        }
        if(node.left==null&&node.right==null){
            sum = Math.max(res, sum);
            return res;
        }
    
        if(node.left!=null){
            int left = helper(node.left);
            if(node.val+1==node.left.val){
                res = Math.max(res, 1+left);
            }
        }
        
        if(node.right!=null){
            int right = helper(node.right);
            if(node.val+1==node.right.val){
                res = Math.max(res, 1+right);
            }
        }
            
        
        sum =Math.max(res, sum);
        return res;
    }
}