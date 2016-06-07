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
            if(head.val<mid.next.val){
                leftTail.next = head;
                leftTail = leftTail.next;
                head = head.next;
            }else if(head.val>mid.next.val){
                rightTail.next = head;
                rightTail = rightTail.next;
                head = head.next;
            }else{
                middleTail.next = head.next;
                middleTail = middleTail.next;
                head = head.next;
            }
        }
        
        leftTail.next = null;
        rightTail.next = null;
        middleTail.next = null;
        
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);
        return concat(left, middleDummy, right);
        
        
    }
    
    private ListNode concat(ListNode node1, ListNode node2, ListNode node3){
        ListNode leftTail = getTail(node1);
        ListNode midTail = getTail(node2);
        leftTail.next = node2;
        midTail.next = node3;
        return node1;
    }
    
    private ListNode getTail(ListNode node){
        if(node==null){
            return node;
        }
        while(!node.next=null){
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