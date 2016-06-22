public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> ans = new ArrayList();
        if(tickets==null){
            return ans;
        }
        
        HashMap<String, PriorityQueue<String>> map = new HashMap();
        for(int i=0; i<tickets.length; i++){
            
        //--------------注意这里不是if和else---------------
            if(!map.containsKey(tickest[i][0])){
                map.put(tickets[i][0], new PriorityQueue());
            }
            map.get(tickets[i][0]).add(tickets[i][1]);
        }
        dfs("JFK", map, ans);
        Collections.reverse(ans);
        return ans;
        
    }
    
    private void dfs(String cur, HashMap<String, PriorityQueue<String>> map, List<String> ans){
        while(map.containsKey(cur) && !map.get(cur).isEmpty()){
            dfs(map.get(cur).poll(), map, ans);
        }
        ans.add(cur);
    }
}