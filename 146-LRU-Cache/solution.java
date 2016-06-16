import java.util.Hashtable;
public class LRUCache {
    private class Node{
        int key;
        int value;
        //Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    Node head = new Node(-1, -1);
    //Node tail = new Node(-1);
    int capacity;
    Hashtable<Integer, Node> hash;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hash = new Hashtable(capacity);
        head.next = null;
        //tail.next = head;
    }
    
    public int get(int key) {
        if(hash.containsKey(key)){
            System.out.println("How are u doing123");
            Node temp = head;
            Node insert = null;
            while(temp.next!=null){
                if(temp.next==hash.get(key)){
                    insert = temp.next;
                    temp.next = temp.next.next;
                }else{
                    temp = temp.next;
                }
            }
            insert.next = head.next;
            head.next = insert;
            //temp.next = new Node(hash.get(key).value);
            return hash.get(key).value;
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(get(key)!=-1){
            System.out.println("How are u doing1");
            hash.get(key).value = value;
        }else if(hash.size()==capacity){
            System.out.println("How are u doing2");
            Node temp = head;
            while(temp.next!=null&&temp.next.next!=null){
                temp = temp.next;
            }
            hash.remove(temp.next.key);
            temp.next = null;
            Node insert = new Node(key, value);
            insert.next = head.next;
            head.next = insert;
            hash.put(key, insert);
        }else{
            System.out.println("How are u doing3");
            Node insert = new Node(key, value);
            insert.next = head.next;
            head.next = insert;
            hash.put(key, insert);
            System.out.println("How are u doing3");
        }
    }
}