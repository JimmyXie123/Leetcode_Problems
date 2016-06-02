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
     public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if(Math.min(minDepth(root.left), minDepth(root.right))>0){
            return Math.min(minDepth(root.left), minDepth(root.right))+1;
        }else{
            return Math.max(minDepth(root.left), minDepth(root.right))+1;
        }
    }
/*
    public int getMin(TreeNode root){
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
*/  
    
}