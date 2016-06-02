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
        return getMin(root);
        /*
        if(Math.min(minDepth(root.left), minDepth(root.right))>0){
            return Math.min(minDepth(root.left), minDepth(root.right))+1;   想想为什么会time limited
        }else{
            return Math.max(minDepth(root.left), minDepth(root.right))+1;
        }*/  
    }
    
    private int getMin(TreeNode node){
        if(node==null){
            return Integer.MAX_VALUE;
        }
        if(node.left==null&&node.right==null){
            return 1;
        }
        return Math.min(getMin(node.left), getMin(node.right))+1;
    }
}