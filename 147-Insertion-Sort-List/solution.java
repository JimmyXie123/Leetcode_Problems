/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while(head!=null){
            if(dummy.next==null){
                dummy.next = new ListNode(head.val);
                head = head.next;
                continue;
            }
            ListNode pointer = dummy;
            while(pointer.next!=null&&head.val>pointer.next.val){
                pointer = pointer.next;
            }
            ListNode tmp = pointer.next;
            pointer.next = new ListNode(head.val);
            pointer.next.next = tmp;
            head = head.next;
        }
        return dummy.next;
    }
}