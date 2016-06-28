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
        ArrayList<Integer> res = new ArrayList();
        helper(root, res, k);
        return res.get(k-1).intValue();
    }
    
    private void helper(TreeNode node, ArrayList<Integer> res, int k){
        if(res.size()==k){
            return;
        }
        if(node==null){
            return;
        }
        helper(node.left, res, k);
        res.add(node.val);
        helper(node.right, res, k);
        
    }
}