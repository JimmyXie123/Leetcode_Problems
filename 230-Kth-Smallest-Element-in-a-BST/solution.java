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
    
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<TreeNode> res = new ArrayList();
        helper(root, res, k);
        return res.get(k-1);
    }
    
    private void helper(TreeNode node, ArrayList<TreeNode> res, int k){
        if(res.size()==k){
            return;
        }
        if(node==null){
            return;
        }
        helper(node.left, res, k);
        res.add(node);
        helper(node.right, res, k);
        
    }
}