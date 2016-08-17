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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList();
        if(start>end){
            return res;
        }
        
        for(int i=start; i<=end; i++){
            List<TreeNode> left = helper(start, i-1);
            List<TreeNode> right = helper(i+1, end);
            if(!left.isEmpty()&&!right.isEmpty()){
                for(TreeNode l:left){
                    for(TreeNode r:right){
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }else if(!left.isEmpty()&&right.isEmpty()){
                for(TreeNode l:left){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    res.add(root);
                }
            }else if(left.isEmpty()&&!right.isEmpty()){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(i);
                    root.right = r;
                    res.add(root);
                }
            }else{
                TreeNode root = new TreeNode(i);
                res.add(root);
            }
        }
        return res;
    }
}