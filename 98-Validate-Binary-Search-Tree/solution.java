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
        TreeNode prev = null;
        TreeNode higher = null;
        
        
        while(root!=null||!stack.isEmpty()) {
            while(root!=null) {
                if(prev!=null&&root.val<=prev.val) return false;
                if(!stack.isEmpty()&&root.val>=stack.peek().val) return false;
                
                stack.push(root);
                root = root.left;
            }
            
            prev = stack.pop();
            if(!stack.isEmpty()){
                higher = stack.peek();
            }else{
                higher = null;
            }
            if(prev.right!=null&&prev.right.val<=prev.val)  return false;
            if(prev.right!=null&&higher!=null&&prev.right.val>=higher.val)  return false;
            root = prev.right;
        }
        
        return true;
    }
}