/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k<=1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next!=null){
            head = reverseKnodes(head, k);
        }
        return dummy.next;
    }
    
    private ListNode reverseKnodes(ListNode head, int k){
        ListNode next = head;
        for(int i=0; i<k; i++){
            if(next.next==null){
                return next;
            }
            next = next.next;
        }
        
        ListNode n1 = head.next;
        ListNode prev = head;
        ListNode curt = head.next;
        for(int i=0; i<k; i++){
            ListNode tmp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = tmp;
        }
        head.next = prev;
        n1.next = curt;
        return n1;
    }
}