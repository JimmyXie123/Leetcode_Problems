/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if(head==null){
            return new ListNode(1);
        }
        
        ListNode rev = reverse(head);
        if(rev.val+1<10){
            rev.val = rev.val+1;
            return reverse(rev);
        }
        
        int advance=1;
        ListNode p = rev;
        p.val = p.val+1-10;
        p = p.next;
        
        while(p!=null){
            if(p.val+advance>=10){
                p.val = p.val+advance-10;
                advance = 1;
            }else{
                p.val = p.val+advance;
                advance = 0;
            }
            p = p.next;
        }
        
        ListNode res;
        if(advance==1){
            ListNode tmp = reverse(rev);
            res = new ListNode(1);
            res.next = tmp;
        }else{
            res = reverse(rev);
        }
        
        return res;
    }
    
    private ListNode reverse(ListNode node){
        ListNode prev = null;
        while(node!=null){
            ListNode tmp = node.next;
            node.next = prev;
            prev = node;
            node = tmp;
        }
        return prev;
    }
}