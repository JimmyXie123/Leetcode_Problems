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
        root.next = null;
        
        while(root!=null){
            TreeLinkNode first = null;
            TreeLinkNode prev = root;
            boolean is_left = false;
            
            while(prev!=null){
                if(prev.left==null&&prev.right==null){
                    prev = prev.next;
                }else if(prev.left!=null){
                    first = prev.left;
                    is_left = true;
                    break;
                }else{
                    first = prev.right;
                    break;
                }
            }
            if(first==null) break;
            root = first;
            
            if(is_left){
                if(prev.right!=null){
                    first.next = prev.right;
                    first = first.next;
                }
            }
            
            prev = prev.next;
            
            while(prev!=null){
                if(prev.left!=null){
                    first.next = prev.left;
                    first = first.next;
                }
                if(prev.right!=null){
                    first.next = prev.right;
                    first = first.next;
                }
                prev = prev.next;
            }
            first.next = null;
        }
    }
}