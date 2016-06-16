import java.util.Hashtable;
public class LRUCache {
    private class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    
    int capacity;
    Hashtable<Integer, Node> hash;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hash = new Hashtable(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hash.containsKey(key)){
            Node current = hash.get(key);
            current.prev.next = current.next;
            current.next.prev = current.prev;
            moveToTail(current);
            
            return hash.get(key).value;
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(get(key)!=-1){
            
            hash.get(key).value = value;
        }else{
            if(hash.size()==capacity){
                Node temp = head.next;
                head.next = temp.next;
                temp.next.prev = head;
                //head.next = head.next.next;
                //head.next.prev = head;
                hash.remove(temp.key);
            }
            
            Node insert = new Node(key, value);
            Node temp = tail.prev;
            tail.prev = insert;
            temp.next = insert;
            insert.next = tail;
            insert.prev = temp;
            //moveToTail(insert);
            hash.put(key, insert);
        }
    }
    
    private void moveToTail(Node current){
        current.next = tail;
        current.prev = tail.prev;
        tail.prev.next = current;
        tail.prev = current;
    }
}