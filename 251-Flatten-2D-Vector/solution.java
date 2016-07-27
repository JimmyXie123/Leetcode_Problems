public class Vector2D implements Iterator<Integer> {
    Queue<Integer> queue;
    public Vector2D(List<List<Integer>> vec2d) {
        queue = new LinkedList();
        int i=0;
        while(i<vec2d.size()){
            int j=0;
            while(j<vec2d.get(i).size()){
                queue.offer(vec2d.get(i).get(j));
                j++;
            }
            i++;
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */