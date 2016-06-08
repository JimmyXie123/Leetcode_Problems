/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = head;
        for(int i=0; i<=n; i++){
            head = head.next;
        }
        while(head!=null){
            head = head.next;
            tail = tail.next;
        }
        if(tail.next!=null){
            tail.next = tail.next.next;
        }
        return dummy.next;
        
    }
}