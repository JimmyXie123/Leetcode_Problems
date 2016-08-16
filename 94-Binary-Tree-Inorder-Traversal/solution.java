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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> res = new ArrayList();
        if(root==null){
            return res;
        }
        
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if(curr.right!=null) {
                curr = curr.right;
                while(curr!=null){
                    stack.push(curr);
                    curr = curr.left;
                }
            }
        }
        
        return res;
    }
}