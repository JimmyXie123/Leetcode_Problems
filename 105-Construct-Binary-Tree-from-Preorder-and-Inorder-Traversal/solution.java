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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int pstart, int pend, int istart, int iend){
        if(pstart==pend){
            return new TreeNode(preorder[pstart]);
        }
        
        if(pstart>pend){
            return null;
        }
        
        int in_pos = findPosition(inorder, preorder[pstart]);
        TreeNode root = new TreeNode(inorder[in_pos]);
        TreeNode left = helper(preorder, inorder, pstart+1, in_pos-istart+pstart, istart, in_pos-1);
        TreeNode right = helper(preorder, inorder, in_pos-istart+pstart+1, pend, in_pos+1, iend);
        root.left = left;
        root.right = right;
        return root;
    }
    
    private int findPosition(int[] inorder, int key){
        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==key){
                return i;
            }
        }
        return inorder.length;
    }
}