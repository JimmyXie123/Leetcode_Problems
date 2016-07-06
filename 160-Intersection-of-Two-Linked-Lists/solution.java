/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode node = headA;
        while(node!=null&&node.next!=null){
            node = node.next;
        }
        node.next = headB;
        ListNode res = listCycle(headA);
        node.next = null;
        return res;
    }
    
    private ListNode listCycle(ListNode node){
        ListNode slow = node, fast = node.next;
        while(fast!=slow){
            if(fast==null||fast.next==null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = fast.next;
        slow = node;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
        
    }
}