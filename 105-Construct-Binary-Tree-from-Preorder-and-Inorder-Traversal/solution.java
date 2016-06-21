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
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    
    private TreeNode myBuildTree(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend){
        if(instart>inend){
            return null;
        }
        int pos = findPosition(inorder, instart, inend, preorder[prestart]);
        TreeNode root = new TreeNode(preorder[prestart]);
        
        root.left = myBuildTree(inorder, instart, pos-1, preorder, prestart+1, prestart+pos-instart);
        root.right = myBuildTree(inorder, pos+1, inend, preorder, prestart+pos-instart+1, preend);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length){
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
    }
}