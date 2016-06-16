public class LRUCache {
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    private int capacity;
    private HashMap<Integer, Node> hash = new HashMap();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(hash.containsKey(key)){
            Node current = hash.get(key);
            current.prev.next = current.next;
            current.next.prev = current.prev;
            moveToTail(current);
            return current.value;
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(get(key)!=-1){
            Node current = hash.get(key);
            current.value = value;
        }else{
            if(hash.size()==capacity){
                Node temp = head.next;
                head.next = head.next.next;
                head.next.prev = head;
                hash.remove(temp.key);
            }
            Node insert = new Node(key, value);
            moveToTail(insert);
            hash.put(key,insert);
        }
    }
    
    private void moveToTail(Node current){
        Node temp = tail.prev;
        tail.prev = current;
        temp.next = current;
        current.prev = temp;
        current.next = tail;
    }
}