public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p1.i1+p1.i2-p2.i1-p2.i2;   
            }
        });
        for(int num1:nums1){
            for(int num2:nums2){
                heap.offer(new Pair(num1, num2));
            }
        }
        
        int i=0;
        List<int[]> res = new ArrayList();
        while(!heap.isEmpty()&&i<k){
            Pair tmp = heap.poll(); 
            res.add(new int[]{tmp.i1, tmp.i2});
            i++;
        }
        return res;
    }
}

class Pair{
    public int i1;
    public int i2;
    public Pair(int i1, int i2){
        this.i1 = i1;
        this.i2 = i2;
    }
}