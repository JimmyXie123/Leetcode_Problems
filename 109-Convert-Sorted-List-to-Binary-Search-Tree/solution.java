/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    ListNode current;
    private int getSize(ListNode node){
        int size = 0
        if(node!=null){
            size++;
            node = node.next;
        }
        return size;
    }
    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        current = head;
        TreeNode result = helper(size);
        return result;
        
    }
    
    private TreeNode helper(int size){
        if(size<=0){
            return null;
        }
        TreeNode left = helper(size/2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = helper(size-1-size/2);
        root.left = left;
        root.right = right;
        return root; 
    }
    
}