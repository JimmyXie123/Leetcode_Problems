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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList();
        List<List<Integer>> res = new ArrayList();
        traverse(root, sum, list, res);
        return res;
    }
    
    private void traverse(TreeNode node, int sum, List<Integer> list, List<List<Integer>> res){
        if(node==null){
            return;
        }
        
        list.add(node.val);
        if(node!=null&&node.left==null&&node.right==null&&node.val==sum){
            res.add(new ArrayList(list));
        }
        
        traverse(node.left, sum-node.val, list, res);
        traverse(node.right, sum-node.val, list, res);
        list.remove(list.size()-1);
    }
}