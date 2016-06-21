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
    private int findPosition(int[] arr, int start, int end, int key){
        for(int i=start; i<=end; i++){
            if(key==arr[i]){
                return i;
            }
        }
        return -1;
    }
    
    private TreeNode myBuildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend){
        if(instart>inend){
            return null;
        }
        
        int pos = findPosition(inorder, instart, inend, postorder[postend]);
        TreeNode root = new TreeNode(postorder[postend]);
        root.left = myBuildTree(inorder, instart, pos-1, postorder, poststart, poststart+pos-1-instart);
        root.right = myBuildTree(inorder, pos+1, inend, postorder, poststart+pos-instart, postend-1);
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return myBuildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
}