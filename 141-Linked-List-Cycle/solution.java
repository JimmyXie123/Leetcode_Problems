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
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> result = new HashSet();
        while(head!=null){
            if(result.contains(head)){
                return true;
            }else{
                result.add(head);
            }
            head = head.next;
        }
        return false;
    }
}