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
        List<String> result = new ArrayList();
        String str = new String();
        int flag = 0;
        traverse(root, str, result, flag);
        return result;
    }
    
    private void traverse(TreeNode node, String str, List<String> result, int flag){
        if(node==null){
            return;
        }
        if(flag==1){
            str = str+"->"+node.val;
        }else{
            str = str+node.val;
            flag = 1;
        }
        if(node.left==null&&node.right==null){
            result.add(new String(str));
        }
        traverse(node.left, str, result, flag);
        traverse(node.right, str, result, flag);
        str = str.substring(0, str.length());
    }
}