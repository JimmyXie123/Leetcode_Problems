public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap();
        for(String[] ticket:tickets){
            if(!map.containsKey(ticket[0])) map.put(ticket[0], new PriorityQueue());
            map.get(ticket[0]).offer(ticket[1]);
        }
        
        List<String> res = new ArrayList();
        helper(map, "JFK", res);
        Collections.reverse(res);
        return res;
    }
    
    private void helper(HashMap<String, PriorityQueue<String>> map, String str, List<String> res){
        while(map.containsKey(str)&&!map.get(str).isEmpty()){
            helper(map, map.get(str).poll(), res);
        }
        res.add(str);
        
    }
}