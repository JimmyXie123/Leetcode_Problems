/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode temp = head;
        while(temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next = temp.next.next;
            }
        }
        return head;
    }
}