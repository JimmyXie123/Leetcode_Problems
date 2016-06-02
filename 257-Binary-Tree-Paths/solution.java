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
        if(root==null){
            return result;
        }
        String str = root.val;
        //int flag = 0;
        traverse(root.left, str, result);
        traverse(root.right, str, result);
        return result;
    }
    
    private void traverse(TreeNode node, String str, List<String> result){
        if(node==null){
            return;
        }
        //if(flag==1){
            str = str+"->"+node.val;
        //}else{
        //  str = str+node.val;
        //    flag = 1;
        //}
        if(node.left==null&&node.right==null){
            result.add(new String(str));
        }
        traverse(node.left, str, result);
        traverse(node.right, str, result);
        str = str.substring(0, str.length());
    }
}