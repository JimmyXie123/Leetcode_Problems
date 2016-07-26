public class ZigzagIterator {
    Queue<Integer> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList();
        int len = Math.min(v1.size(), v2.size());
        for(int i=0; i<len; i++){
            queue.offer(v1.get(i));
            queue.offer(v2.get(i));
        }
        if(v1.size()>v2.size()){
            for(int i=len; i<v1.size(); i++){
                queue.offer(v1.get(i));
            }
        }else{
            for(int i=len; i<v2.size(); i++){
                queue.offer(v2.get(i));
            }
        }
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */