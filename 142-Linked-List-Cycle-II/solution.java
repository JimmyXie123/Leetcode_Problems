/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> tank = new HashSet();
        while(head!=null){
            if(tank.contains(head)){
                return head;
            }else{
                tank.add(head);
                head = head.next;
            }
        }
        return null;
    }
}