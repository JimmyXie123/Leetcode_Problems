public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        HashMap<String, List<String>> graph = new HashMap();   //-------use space to save time--------
        HashMap<String, Integer> distance = new HashMap();  
        List<List<String>> res = new ArrayList();
        
        for(String str:wordList)  graph.put(str, new ArrayList());
        bfs(distance, graph, endWord, wordList);
        List<String> path = new ArrayList();
        dfs(endWord, res, path, distance, graph, beginWord, endWord);
        return res;
        
    }
    
    private void bfs(HashMap<String, Integer> distance, HashMap<String, List<String>> graph, String endWord, Set<String> wordList){
        Queue<String> queue = new LinkedList();
        queue.offer(endWord);
        distance.put(endWord, 0);
        
        while(!queue.isEmpty()){
            String curr = queue.poll();
            for(String next:getWords(curr, wordList)){
                graph.get(curr).add(next);
                if(!distance.containsKey(next)){
                    distance.put(next, distance.get(curr)+1);
                    queue.offer(next);
                }
            }
        }
    }
    
    private void dfs(String curr, List<List<String>> res, List<String> path, HashMap<String, Integer> distance, HashMap<String, List<String>> graph, String beginWord, String endWord){
        path.add(curr);
        if(curr.equals(beginWord)){
            Collections.reverse(path);
            res.add(new ArrayList(path));
            Collections.reverse(path);
        }else{
            for(String next:graph.get(curr)){
                if(distance.containsKey(next)&&distance.get(next)==distance.get(curr)+1){
                    dfs(next, res, path, distance, graph, beginWord, endWord);
                }
            }
        }
        path.remove(path.size()-1);  //---------plz dont forget about it---------------
        
    }
    
    private String replace(String cur, int position, char c){
        char[] ch = cur.toCharArray();
        ch[position] = c;
        return new String(ch);
    }
    
    private List<String> getWords(String cur, Set<String> wordList){
        List<String> res = new ArrayList();
        for(int i=0; i<cur.length(); i++){
            for(char c='a'; c<='z'; c++){
                if(c==cur.charAt(i)) continue;
                String tmp = replace(cur, i, c);
                if(wordList.contains(tmp)) res.add(tmp);
            }
        }
        return res;
    }
}