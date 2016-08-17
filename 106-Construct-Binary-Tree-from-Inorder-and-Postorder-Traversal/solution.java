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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int istart, int iend, int pstart, int pend){
        if(istart>iend){
            return null;
        }
        
        int in_pos = findPosition(inorder, postorder[pend]);
        
        TreeNode root = new TreeNode(postorder[pend]);
        TreeNode left = helper(inorder, postorder, istart, in_pos-1, pstart, pstart+in_pos-1-istart);
        TreeNode right = helper(inorder, postorder, in_pos+1, iend, pstart+in_pos-istart, pend-1);
        root.left = left;
        root.right = right;
        return root;
    }
    
    private int findPosition(int inorder[], int key){
        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==key){
                return i;
            }
        }
        return inorder.length;
    }
}