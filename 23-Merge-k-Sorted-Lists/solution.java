/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val-l2.val;
            }
        });
        for(ListNode l:lists){
            if(l!=null)  heap.offer(l);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode pointer = dummy;
        while(!heap.isEmpty()){
            ListNode head = heap.poll();
            pointer.next = head;
            pointer = pointer.next;
            if(head.next!=null) heap.offer(head.next);
        }
        return dummy.next;
    }
}