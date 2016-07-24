public class Solution {
     public String rearrangeString(String str, int k) {
        
        StringBuilder res = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue(new Comparator<Map.Entry<Character, Integer>>(){
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2){
                return entry2.getValue()-entry1.getValue();
            }
        });
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList();
        maxHeap.addAll(map.entrySet());
        
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> current = maxHeap.poll();
            res.append(current.getKey());
            current.setValue(current.getValue()-1);
            queue.offer(current);
            
            if(queue.size()<k) continue;
            
            Map.Entry<Character, Integer> front = queue.poll();
            if(front.getValue()>0){
                maxHeap.offer(front);
            }
        }
        
        return res.length()==str.length()?res.toString():"";
        
        
    }
}