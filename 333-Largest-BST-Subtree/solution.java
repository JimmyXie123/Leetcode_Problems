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
    boolean isBST;
    int max;
    int min;
    int num;
    public returnType(boolean isBST, int max, int min, int num){
        this.isBST = isBST;
        this.max = max;
        this.min = min;
        this.num = num;
    }
}


public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root==null)  return 0;
        return helper(root).num;
    }
    
    private returnType helper(TreeNode node){
       if(node.left!=null&&node.right!=null){
           returnType left = helper(node.left);
           returnType right = helper(node.right);
           if(left.isBST&&right.isBST&&node.val>left.max&&node.val<right.min){
               return new returnType(true, right.max, left.min, left.num+right.num+1);
           }else{
               return new returnType(false, right.max, left.min, Math.max(left.num, right.num));
           }
       }else if(node.left!=null){
           returnType left = helper(node.left);
           if(left.isBST&&node.val>left.max){
               return new returnType(true, node.val, left.min, left.num+1);
           }else{
               return new returnType(false, node.val, left.min, left.num);
           }
       }else if(node.right!=null){
           returnType right = helper(node.right);
           if(right.isBST&&node.val<right.min){
               return new returnType(true, right.max, node.val, right.num+1);
           }else{
               return new returnType(false, right.max, node.val, right.num);
           }
       }else{
           return new returnType(true, node.val, node.val, 1);
       }
    }
}