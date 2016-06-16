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
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    
    public int get(int key) {
        if(hash.containsKey(key)){
            moveToTail(hash.get(key));
            return hash.get(key).value;
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(get(key)!=-1){
            hash.get(key).value = value;
        }else{
            System.out.println("123");
            if(hash.size()==capacity){
                Node temp = head.next;
                head.next = head.next.next;
                head.next.prev = head;
                hash.remove(temp.key);
            }
            
            Node insert = new Node(key, value);
            head.next.prev = insert;
            insert.next = head.next;
            head.next =insert;
            insert.prev = head; 
            hash.put(key, insert);
        }
    }
    
    private void moveToTail(Node current){
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.next = tail;
        current.prev = tail.prev;
    }
}