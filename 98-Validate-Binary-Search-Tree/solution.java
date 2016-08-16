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
        if(root==null) return true;
        Stack<TreeNode> stack = new Stack();
        TreeNode curt = root;
        TreeNode prev = null;
        while(curt!=null||!stack.isEmpty()){
            while(curt!=null){
                stack.push(curt);
                curt = curt.left;
            }
            TreeNode tmp = stack.pop();
            if(prev!=null&&prev.val>=tmp.val){
                return false;
            }
            prev = tmp;
            curt = tmp.right;
        }
        
        return true;
    }
}