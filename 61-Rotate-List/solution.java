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
        int size = getSize(head);
        int position;
        
        if(size>k){
            position = k;
        }else{
            position = k-size;
            while(position>size){
                position = position-size;
            }
        }
        
        int leftLength = size-position;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for(int i=0; i<leftLength; i++){
            head = head.next;
        }
        
        
        ListNode temp = head.next, pointer = head;
        ListNode temp_dummynext = dummy.next;
        while(pointer.next!=null){
            pointer = pointer.next;
        }
        if(temp!=null){
            dummy.next = head;
            pointer.next = temp_dummy.next;
        }
        head.next = null;
        
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