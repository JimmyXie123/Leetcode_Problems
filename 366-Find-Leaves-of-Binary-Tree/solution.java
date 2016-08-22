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
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> findLeaves(TreeNode root) {
        helper(root);
        return res;
    }
    
    private int helper(TreeNode node){
        if(node==null)  return -1;
        int height = Math.max(helper(node.left), helper(node.right))+1;;
        if(res.size()<height+1)   res.add(new ArrayList<Integer>());
        
        res.get(height).add(node.val);
        return height;
    }
}