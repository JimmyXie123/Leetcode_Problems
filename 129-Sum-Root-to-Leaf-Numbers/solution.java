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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        List<Integer> num = new ArrayList();
        traverse(root, num);
        return sum;
    }
    
    private void traverse(TreeNode node, List<Integer> num){
        if(node==null){
            return;
        }
        
        num.add(node.val);
        if(node.left==null&&node.right==null) sum += count(num);
        if(node.left!=null) traverse(node.left, num);
        if(node.right!=null) traverse(node.right, num);
        num.remove(num.size()-1);
    }
    
    private int count(List<Integer> num){
        int res = 0;
        for(int i=0; i<num.size(); i++){
            res *= 10;
            res += num.get(i);
        }
        return res;
    }
}