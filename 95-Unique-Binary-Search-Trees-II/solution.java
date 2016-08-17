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
        return helper(n, 0);
    }
    
    private List<TreeNode> helper(int n, int makeup){
        List<TreeNode> res = new ArrayList();
        if(n==0){
            return res;
        }
        
        for(int i=1; i<=n; i++){
            List<TreeNode> left = helper(i-1, makeup);
            List<TreeNode> right = helper(n-i, makeup+i);
            if(!left.isEmpty()&&!right.isEmpty()){
                for(TreeNode l:left){
                    for(TreeNode r:right){
                        TreeNode root = new TreeNode(i+makeup);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }else if(!left.isEmpty()&&right.isEmpty()){
                for(TreeNode l:left){
                    TreeNode root = new TreeNode(i+makeup);
                    root.left = l;
                    res.add(root);
                }
            }else if(left.isEmpty()&&!right.isEmpty()){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(i+makeup);
                    root.right = r;
                    res.add(root);
                }
            }else{
                TreeNode root = new TreeNode(i+makeup);
                res.add(root);
            }
        }
        return res;
    }
}