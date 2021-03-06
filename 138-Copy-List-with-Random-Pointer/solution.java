/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    private void Copy(RandomListNode node){
        while(node!=null){
            RandomListNode temp = new RandomListNode(node.label);
            temp.next = node.next;
            temp.random = node.random;
            node.next = temp;
            node = temp.next;
        }
    }
    
    private void CopyRandom(RandomListNode node){
        while(node!=null){
            if(node.next.random!=null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
    }
    
    private RandomListNode splitList(RandomListNode node){
        RandomListNode newHead = node.next;
        while(node!=null){
            RandomListNode temp = node.next;
            node.next = temp.next;
            if(temp.next!=null){
                temp.next = temp.next.next;
            }
            node = node.next;
        }
        return newHead;
    }
    
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return head;
        }
        Copy(head);
        CopyRandom(head);
        return splitList(head);
    }
}