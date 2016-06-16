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
            System.out.println(hash.get(key).value);
            return hash.get(key).value;
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(get(key)!=-1){
            System.out.println(key+"111111111");
            hash.get(key).value = value;
        }else{
            if(hash.size()==capacity){
                System.out.println("123"+" "+key);
                System.out.println(hash.get(2).key);
                System.out.println("head"+head.next.key);
                System.out.println("tail"+tail.next.key);
                Node temp = head.next;
                //head.next = temp.next;
                //temp.next.prev = head;
                head.next = head.next.next;
                head.next.prev = head;
                hash.remove(temp.key);
            }
            System.out.println("key="+key);
            Node insert = new Node(key, value);
            Node temp = tail.prev;
            tail.prev = insert;
            temp.next = insert;
            insert.next = tail;
            insert.prev = temp;
            hash.put(key, insert);
        }
    }
    
    private void moveToTail(Node current){
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.next = tail;
        current.prev = tail.prev;
        tail.prev.next = current;
        tail.prev = current;
    }
}