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
        int l = left(root);
        int r = right(root);
        if(l==r){
            return (1<<l)-1;
        }else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }
    
    private int left(TreeNode node){
        int h=0;
        while(node!=null){
            h++;
            node = node.left;
        }
        return h;
    }
    
    private int right(TreeNode node){
        int h=0; 
        while(node!=null){
            h++;
            node = node.right;
        }
        return h;
    }
}