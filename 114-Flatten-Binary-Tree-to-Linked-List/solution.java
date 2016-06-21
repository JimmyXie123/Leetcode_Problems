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
    TreeNode last;
    public void flatten(TreeNode root) {
        traverse(root);
        return;
    }
    
    public void traverse(TreeNode node){
        if(node==null){
            return;
        }
        
        if(last==null){
            last = node; 
        }else{
            last.left = null;
            last.right = node;
        }
        last = node;
        TreeNode right = node.right;  /*------------important!!!!!!!!!!!!!!-------
                                        走完node之后，node变成last，last在下一轮中left，right指针就变了，左指针不再需要，
                                        而右指针还需在用--------------*/
        traverse(node.left);
        traverse(right);
    }
}