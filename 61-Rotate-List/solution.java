/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        int size = getSize(head);
        int n = k%size;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = dummy;
        
        for(int i=0; i<n; i++){
            head = head.next;
        }
        
        while(head.next!=null){
            head = head.next;
            tail = tail.next;
        }
        
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
    private int getSize(ListNode node){
        int size = 0;
        while(node!=null){
            node = node.next;
            size++;
        }
        return size;
    }
}