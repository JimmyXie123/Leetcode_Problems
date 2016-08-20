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
    public int countNodes(TreeNode root) {
        if(root==null)  return 0;
        int l = height(root.left);
        int r = height(root.right);
        if(l==r){
            return (1<<l)+countNodes(root.right);
        }else{
            return (1<<r)+countNodes(root.left);
        }
    }
    
    private int height(TreeNode node) {
        int h = 0;
        while(node!=null){
            h++;
            node = node.left;
        }
        return h;
    }
}