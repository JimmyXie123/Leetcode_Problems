/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Node{
    boolean visited;
    TreeNode treenode;
    public Node(boolean visited, TreeNode treenode){
        this.visited = visited;
        this.treenode = treenode;
    }
}
 
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<Node> stack = new Stack();
        List<Integer> res = new ArrayList();
        if(root==null){
            return res;
        }
        
        while(root!=null){
            stack.push(new Node(false, root));
            root = root.left;
        }
        
        while(!stack.isEmpty()){
            if(stack.peek().visited||stack.peek().treenode.right==null){
                Node tmp = stack.pop();
                res.add(tmp.treenode.val);
            }else{
                stack.peek().visited = true;
                TreeNode subroot = stack.peek().treenode.right; 
                while(subroot!=null){
                    stack.push(new Node(false, subroot));
                    subroot = subroot.left;
                }
            }
        }
        return res;
    }
}