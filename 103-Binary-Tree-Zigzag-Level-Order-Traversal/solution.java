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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> result = new ArrayList();
        if(root==null){
            return result;
        }
        queue.offer(root);
        int order = 0;
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            if(flag==1){
                List<Integer> reverse = new ArrayList();
                for(int i=temp.size()-1; i>=0; i++){
                    reverse.add(temp.get(i));
                }
                temp =reverse;
                flag=0;
            }
            result.add(temp);
        }
        return result;
    }
}