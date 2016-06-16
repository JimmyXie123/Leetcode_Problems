import java.util.Hashtable;
public class LRUCache {
    private class Node{
        //int key;
        int value;
        //Node prev;
        Node next;
        public Node(int value){
            //this.key = key;
            this.value = value;
        }
    }
    
    Node head = new Node(-1);
    //Node tail = new Node(-1);
    Hashtable<Integer, Node> hash;
    
    public LRUCache(int capacity) {
        hash = new Hashtable(capacity);
        head.next = null;
        //tail.next = head;
    }
    
    public int get(int key) {
        if(hash.contains(key)){
            Node temp = head;
            Node insert = null;
            while(temp.next!=null){
                if(temp.next==hash.get(key)){
                    insert = temp.next;
                    temp.next = temp.next.next;
                }
                temp = temp.next;
            }
            temp.next = insert;
            insert.next = null;
            //temp.next = new Node(hash.get(key).value);
            return hash.get(key).value;
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(get(key)!=-1){
            hash.get(key).value = value;
        }else if(hash.size()==capacity){
            temp = head;
            while(temp.next!=null&&temp.next.next!=null){
                temp = temp.next;
            }
            temp.next = null;
            Node insert = new Node(value);
            insert.next = head.next;
            head.next = insert;
            hash.put(key, insert);
        }else{
            Node insert = new Node(value);
            insert.next = head.next;
            head.next = insert;
            hash.put(key, insert);
        }
    }
}