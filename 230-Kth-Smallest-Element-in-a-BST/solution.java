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
    int curt = 0;
    int res=0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }
    
    private void traverse(TreeNode node, int k){
        if(node==null){
            return;
        }
        
        traverse(node.left, k);
        curt++;
        if(curt==k){
            res = node.val;
            return;
        }
        traverse(node.right, k);
    }
}