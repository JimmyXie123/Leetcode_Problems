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
        List<List<Integer>> result = new ArrayList();
        List<Integer> path = new ArrayList();
        traverse(root, sum, path, result);
        return result;
    }
    
    private void traverse(TreeNode node, int sum, List<Integer> path, List<List<Integer>> result){
        if(node==null){
            return;
        }
        path.add(node.val);
        if(node.left==null&&node.right==null){
            if(sum==node.val){
                result.add(new ArrayList(path));
            }
        }
        
        traverse(node.left, sum-node.val, path, result);
        traverse(node.right, sum-node.val, path, result);
        path.remove(path.size()-1);
    }
}