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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> result = new ArrayList();
        if(root==null){
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(temp);
        }
        List<List<Integer>> best = new ArrayList();
        for(int i=result.size()-1; i>=0; i--){
            best.add(result.get(i));
        }
        return best;
        
    }
}