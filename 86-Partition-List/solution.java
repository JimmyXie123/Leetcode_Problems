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
        ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
        //ListNode temp = new ListNode(0);
        //temp.next = head;
        //ListNode pointer2 = dummy_big;//-------------------思考
        while(head!=null){
            if(head.val<x){
                leftTail.next = head;
                leftTail = leftTail.next;
                head = head.next;
            }else{
                rightTail.next = head;
                rightTail = rightTail.next;
                head = head.next;
            }
        }
        rightTail.next = null;
        leftTail.next = rightDummy.next; 
        return leftDummy.next;
    }
}