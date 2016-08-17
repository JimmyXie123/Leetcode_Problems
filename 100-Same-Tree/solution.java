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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()){
            TreeNode p1 = queue.poll();
            TreeNode p2 = queue.poll();
            if(p1==null&&p2==null)  continue;
            if(p1==null||p2==null)  return false;
            if(p1.val!=p2.val)  return false;
            queue.offer(p1.left);
            queue.offer(p2.left);
            queue.offer(p1.right);
            queue.offer(p2.right);
        }
        return true;
    }
}