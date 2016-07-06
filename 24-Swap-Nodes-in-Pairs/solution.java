/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next!=null&&head.next.next!=null){
            ListNode tmp = head.next;
            ListNode tmp_next = head.next.next.next;
            head.next = head.next.next;
            head.next.next = tmp; 
            tmp.next = tmp_next;
            head = head.next.next;
            
        }
        return dummy.next;
        
    }
}