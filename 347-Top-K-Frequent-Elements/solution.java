class element{
    int key;
    int value;
    public element(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Queue<element> heap = new PriorityQueue(k, new Comparator<element>(){
            public int compare(element e1, element e2){
                return e2.value-e1.value;
            }
        });
        
        HashMap<Integer, Integer> map = new HashMap();
        for(int i:nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        
        for(int i:map.keySet()){
            element e = new element(i, map.get(i));
            System.out.println(i);
            heap.offer(e);
        }
        
        List<Integer> res = new ArrayList();
        for(int i=0; i<k; i++){
            res.add(heap.poll().key);
        }
        return res;
    }
    

}

