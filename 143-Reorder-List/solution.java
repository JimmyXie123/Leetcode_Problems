/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode front = head;
        ListNode mid = findMiddle(head);
        ListNode back = reverse(mid.next);
        mid.next = null;
        head = merge(front, back);
    }
    
    private ListNode findMiddle(ListNode head){
        ListNode slow=head, fast=head.next;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    private ListNode merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while(node1!=null&&node2!=null){
            pointer.next = node1;
            node1 = node1.next;
            pointer = pointer.next;
            pointer.next = node2;
            node2 = node2.next;
            pointer = pointer.next;
        }
        while(node1!=null&&node2==null){
            pointer.next = node1;
            node1 = node1.next;
            pointer = pointer.next;
        }
        while(node1==null&&node2!=null){
            pointer.next = node2;
            node2 = node2.next;
            pointer = pointer.next;
        }
        return dummy.next;
    }
}