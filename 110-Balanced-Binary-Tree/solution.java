/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class returnType{
    int height;
    boolean valid;
    public returnType(int height, boolean valid){
        this.height = height;
        this.valid = valid;
    }
}
 
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root).valid;
    }
    
    private returnType helper(TreeNode node){
        if(node==null)  return new returnType(0, true);
        
        returnType l = helper(node.left);
        returnType r = helper(node.right);
        
        if(l.valid&&r.valid&&Math.abs(l.height-r.height)<=1){
            return new returnType(Math.max(l.height, r.height)+1, true);
        }else{
            return new returnType(Math.max(l.height, r.height)+1, false);
        }
        
    }
    
}