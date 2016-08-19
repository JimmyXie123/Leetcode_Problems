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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return sum;
    }
    
    private void traverse(TreeNode node, int num){    //---------it is stupid to use list here--------
        if(node==null){
            return;
        }
        
        if(node.left==null&&node.right==null){
            sum += num*10 + node.val;
            return;
        }else{
            num = num*10 + node.val;
            traverse(node.left, num);
            traverse(node.right, num);
        }
    }
}