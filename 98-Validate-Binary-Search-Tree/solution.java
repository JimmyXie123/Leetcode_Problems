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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        if(root==null)  return true;
        TreeNode pre = null;
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(pre!=null&&tmp.val<=pre.val){
                return false;
            }
            pre = tmp;
            tmp = tmp.right;
            while(tmp!=null){
                stack.push(tmp);
                tmp = tmp.left;
            }
        }
        
        return true;
    }
}