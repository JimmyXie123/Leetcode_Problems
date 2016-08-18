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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null||postorder.length==0)    return null;
        Stack<TreeNode> stack = new Stack();
        int len = postorder.length;
        TreeNode root = new TreeNode(postorder[len-1]) ;
        stack.push(root);
        int index = len-1;
        
        for(int i=len-2; i>=0; i--){
            TreeNode curr = stack.peek();
            if(curr.val!=inorder[index]){
                curr.right = new TreeNode(postorder[i]);
                stack.push(curr.right);
            }else{
                while(!stack.isEmpty()&&stack.peek().val==inorder[index]){
                    curr = stack.pop(); 
                    index--;
                }
                
                curr.left = new TreeNode(postorder[i]);
                stack.push(curr.left);
            }
        }
        return root;
    }
}