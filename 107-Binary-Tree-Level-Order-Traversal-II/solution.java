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
        Queue<Integer> queue = new LinkedList();
        List<List<Integer>> result = new ArrayList();
        if(root==null){
            return result;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<Integer>();
            for(int i=0; i<queue.size(); i++){
                TreeNode node = queue.remove();
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
        List<List<Integer>> final = new ArrayList();
        for(int i=result.size()-1; i>=0; i--){
            final.add(result.get(i));
        }
        return final;
        
    }
}