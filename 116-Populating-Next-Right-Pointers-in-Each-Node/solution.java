/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)  return;
        TreeLinkNode parent = root;
        parent.next = null;
        while(parent.left!=null){
            TreeLinkNode prev = parent;
            TreeLinkNode last = null;
            while(prev!=null){
                if(last!=null){
                    last.next = prev.left;
                }
                prev.left.next = prev.right;
                last = prev.right;
                prev = prev.next;
            }
            last.next = null;
            parent = parent.left;
        }
    }
}