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
        ListNode mid = findMiddle(head);
        ListNode back_part = mid.next;
        mid.next = null;
        head = sortList(head);
        back_part = sortList(back_part);
        merge(head, back_part);
        return head;
    }
    
    private ListNode findMiddle(ListNode node){
        if(node==null){
            return node;
        }
        ListNode slow = node;
        ListNode fast = node.next;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private void merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while(node1!=null&&node2!=null){
            if(node1.val<node2.val){
                pointer.next = node1;
                pointer = pointer.next;
                node1 = node1.next;
            }else{
                pointer.next = node2;
                pointer = pointer.next;
                node2 = node2.next;
            }
        }
        while(node1!=null&&node2==null){
            pointer.next = node1;
            pointer = pointer.next;
            node1 = node1.next;
        }
        while(node2!=null&&node1==null){
            pointer.next = node2;
            pointer = pointer.next;
            node2 = node2.next;
        }
        return dummy.next;
    }
}