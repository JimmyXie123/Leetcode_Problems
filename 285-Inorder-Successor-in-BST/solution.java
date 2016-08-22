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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        
        boolean reachTarget = false;
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(reachTarget) return tmp;
            if(tmp==p){
                reachTarget = true;
            }
            tmp = tmp.right;
            while(tmp!=null){
                stack.push(tmp);
                tmp = tmp.left;
            }
        }
        return null;
    }
}