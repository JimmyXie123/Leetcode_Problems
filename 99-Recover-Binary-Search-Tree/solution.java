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
    TreeNode first;
    TreeNode second;
    TreeNode last;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    private void traverse(TreeNode node){
        if(node==null){
            return;
        }
        
        traverse(node.left);
        if(last!=null&&last.val>node.val){
            if(first==null){
                first = last;
            }
            if(first!=null){
                second = node;
            }
        }
        last = node;
    
        traverse(node.right);
    }
}