/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while(l1!=null&&l2!=null){
            if(l1.val>=l2.val){
                result.next = l2; 
                l2 = l2.next;
            }else{
                result.next = l1;
                l1 = l1.next;
            }
            result = result.next;  
        }
        while(l1!=null&&l2==null){
            result.next = l1;
            l1 = l1.next;
            result = result.next;
        }
        while(l1==null&&l2!=null){
            result.next = l2;
            l2 = l2.next;
            result = result.next;
        }
        return dummy.next;
    }
}