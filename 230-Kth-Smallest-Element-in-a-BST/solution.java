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
    public int kthSmallest(TreeNode root, int k) {
        int number = count(root.left);
        if(k==number+1){
            return root.val;
        }else if(k<=number){
            return kthSmallest(root.left, k);
        }else{
            return kthSmallest(root.right, k-number-1);
        }
    }
    
    private int count(TreeNode node){
        if(node==null)  return 0;
        return 1+count(node.left)+count(node.right);
    }
}