/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return head;
        }
        ListNode pointer1 = head;
        ListNode odd = head;
        ListNode pointer2 = head.next;
        ListNode even = head.next;
        while(pointer2!=null&&pointer2.next!=null){
            pointer1.next = pointer2.next;
            pointer2.next = pointer2.next.next;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        pointer1.next = even;
        return odd;
    }
}