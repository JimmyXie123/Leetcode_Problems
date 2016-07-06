/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        ListNode mid = findMiddle(head);
        ListNode right = reverse(mid.next);
        ListNode left = head;
        mid.next = null;
        while(right!=null){
            if(right.val!=left.val){
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }
    
    private ListNode findMiddle(ListNode node){
        ListNode slow = node;
        ListNode fast = node.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode node){
        ListNode prev = null;
        while(node!=null){
            ListNode tmp = node.next;
            node.next = prev;
            prev = node; 
            node = tmp;
        }
        return prev;
    }
}