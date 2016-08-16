public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList();
        List<int[]> res = new ArrayList();
        if(buildings.length==0) return res;
        PriorityQueue<Integer> heap = new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2-i1;
            }
        });
        
        for(int[] b:buildings){
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        
        Collections.sort(heights, new Comparator<int[]>(){
            public int compare(int[] h1, int[] h2){
                if(h1[0]!=h2[0])  return h1[0]-h2[0];
                return h1[1]-h2[1];
            }
        });
        
        heap.offer(0);
        int prev = 0;
        
        for(int[] h:heights){
            if(h[1]<0){
                heap.offer(-h[1]);
            }else if(h[1]>0){
                heap.remove(h[1]);
            }
            if(heap.peek()!=prev){
                res.add(new int[]{h[0], heap.peek()});
                prev = heap.peek();
            }
        }
        
        //
        
        return res;
    }
}