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
    boolean valid;
    int value;
    public returnType(boolean valid, int value){
        this.valid = valid;
        this.value = value;
    }
} 

public class Solution {
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) return 0;
        returnType r = helper(root);
        return res;
    }
    
    private returnType helper(TreeNode node){
        returnType left = null;
        returnType right = null;
        if(node.left!=null) left = helper(node.left);
        if(node.right!=null) right = helper(node.right);
        
        
        boolean tmp_valid;
        int tmp_value;
        if(left!=null&&right!=null) {
            tmp_valid = left.valid&&right.valid&&(left.value==right.value)&&(left.value==node.val);
        }else if(left!=null&&right==null){
            tmp_valid = (node.val==left.value)&&left.valid;
        }else if(left==null&&right!=null){
            tmp_valid = (node.val==right.value)&&right.valid;
        }else{
            tmp_valid = true;
        }
        tmp_value = node.val;
        if(tmp_valid)   res++;
        return new returnType(tmp_valid, tmp_value);
    }
}