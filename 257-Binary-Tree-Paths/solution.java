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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        String path = "";
        helper(root, path, res, true);
        return res;
    }
    
    private void helper(TreeNode node, String path, List<String> res, boolean isFirst){
        if(node==null)  return;
        
        int tmp_length = path.length();
        if(isFirst){
            path += node.val;
            isFirst = false;
        }else{
            path += "->"+node.val;
        }
        
        if(node.left==null&&node.right==null){
            res.add(path);
        }else{
            if(node.left!=null) helper(node.left, path, res, isFirst);
            if(node.right!=null) helper(node.right, path, res, isFirst);
        }
        
        path = path.substring(0, tmp_length);
    }
}