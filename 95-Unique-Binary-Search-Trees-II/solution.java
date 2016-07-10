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
        if(n==0){
            return new ArrayList();
        }
        return generate(1, n);
    }
    
    private List<TreeNode> generate(int start, int end){
        List<TreeNode> rst = new ArrayList<TreeNode>();   
    
        if(start > end){
            rst.add(null);
            return rst;
        }
     
            for(int i=start; i<=end; i++){
                List<TreeNode> left = generate(start, i-1);
                List<TreeNode> right = generate(i+1, end);
                for(TreeNode l: left){
                    for(TreeNode r: right){
// should new a root here because it need to 
// be different for each tree
                        TreeNode root = new TreeNode(i);  
                        root.left = l;
                        root.right = r;
                        rst.add(root);
                    }
                }
            }
        return rst;
    }
}