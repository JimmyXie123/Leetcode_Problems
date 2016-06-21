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
    int pos;
    int[] current;
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null){
            return null;
        }
        current = nums;
        pos = 0;
        return helper(nums.length);
    }
    
    private TreeNode helper(int size){
        if(size<=0){
            return null;
        }
        
        root.left = helper(size/2);
        TreeNode root = new TreeNode(nums[pos++]);
        root.right = helper(size-1-size/2);
        
        return root;
    }
    
    
}