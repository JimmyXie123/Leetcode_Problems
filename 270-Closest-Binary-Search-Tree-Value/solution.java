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
    public int closestValue(TreeNode root, double target) {
        Integer res = null;
        while(root!=null){
            if(res==null)   res = root.val;
            if(Math.abs(root.val-target)<Math.abs(res-target)){
                res = root.val;
            }
            if(root.val>target) {
                root = root.left;
            }else if(root.val<target){
                root = root.right;
            }else{
                return root.val;
            }
        }
        return res;
    }
}