/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy_small = new ListNode(0);
        ListNode dummy_big = new ListNode(0);
        dummy_small.next = head;
        dummy_big.next = head;
        ListNode pointer1 = dummy_small;
        ListNode pointer2 = dummy_big;
        head = dummy_big;
        while(head.next!=null){
            if(head.next.val<x){
                pointer1.next = head.next;
                pointer1 = pointer1.next;
                head.next = head.next.next;
            }else{
                pointer2.next = head.next;
                pointer2 = pointer2.next;
                head = head.next;
            }
        }
        pointer1.next=dummy_big.next;
        return dummy_small.next;
    }
}