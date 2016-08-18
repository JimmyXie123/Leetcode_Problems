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
        List<TreeNode>[] ary = new List[n+1];
        ary[0] = new ArrayList();
        if(n==0)  return ary[0];
        ary[0].add(null);
        
        for(int len=1; len<=n; len++){
            ary[len] = new ArrayList(); 
            for(int i=0; i<len; i++){
                for(TreeNode l:ary[i]){
                    for(TreeNode r:ary[len-1-i]){
                        TreeNode root = new TreeNode(i+1);
                        root.left = l;
                        root.right = clone(r, i+1);
                        ary[len].add(root);
                    }
                }
            }
        }
        
        return ary[n];
    }
    
    private TreeNode clone(TreeNode node, int offset){
        if(node==null)  return null;
        TreeNode root = new TreeNode(node.val+offset);
        root.left = clone(node.left, offset);
        root.right = clone(node.right, offset);
        return root;
    }
}