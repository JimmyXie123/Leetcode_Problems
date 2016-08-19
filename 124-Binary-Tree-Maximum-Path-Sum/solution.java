/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class returnType{
    int maxPath;   //------does not need to include root(contains at least one node)-----
    int rootMax;   //------root has to be included---------
    public returnType(int maxPath, int rootMax){
        this.maxPath = maxPath;
        this.rootMax = rootMax;
    }
}

public class Solution {
    public int maxPathSum(TreeNode root) {
        return helper(root).maxPath;
    }
    
    private returnType helper(TreeNode node){
        if(node==null)  return new returnType(Integer.MIN_VALUE, 0);
        
        returnType left = helper(node.left);
        returnType right = helper(node.right);
        
        int tmp_rootMax = Math.max(node.val+left.rootMax, node.val+right.rootMax);
        tmp_rootMax = Math.max(tmp_rootMax, node.val);
        int tmp_maxPath = Math.max(left.maxPath, right.maxPath);
        tmp_maxPath = Math.max(tmp_maxPath, tmp_rootMax);
        tmp_maxPath = Math.max(tmp_maxPath, left.rootMax+right.rootMax+node.val);
        return new returnType(tmp_maxPath, tmp_rootMax);
    }
}