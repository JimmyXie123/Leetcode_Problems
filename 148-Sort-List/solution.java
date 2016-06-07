/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        
        ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
        ListNode middleDummy = new ListNode(0), middleTail = middleDummy;
        ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
        ListNode mid = findMiddle(head);
        
        while(head!=null){
            if(head.val<mid.val){
                leftTail.next = head;
                leftTail = leftTail.next;
                head = head.next;
            }else if(head.val>mid.val){
                rightTail.next = head;
                rightTail = rightTail.next;
                head = head.next;
            }else{
                middleTail.next = head;
                middleTail = middleTail.next;
                head = head.next;
            }
        }
        
        leftTail.next = null;
        middleTail.next = null;
        rightTail.next = null;
        
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);
        return concat(left, middleDummy.next, right);
        
        
    }
    
    private ListNode concat(ListNode node1, ListNode node2, ListNode node3){
       ListNode dummy = new ListNode(0), tail = dummy;
        tail.next = node1; tail = getTail(tail);
        tail.next = node2; tail = getTail(tail);
        tail.next = node3; tail = getTail(tail);
        return dummy.next;
    }
    
    private ListNode getTail(ListNode node){
        if(node==null){
            return node;
        }
        while(node.next!=null){
            node = node.next;
        }
        return node;
    }
    
    private ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}