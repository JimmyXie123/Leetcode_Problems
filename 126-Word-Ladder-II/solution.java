public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        //----------------beginWord and endWord both included in wordList-------------------
        HashMap<String, Integer> distance = new HashMap();
        HashMap<String, HashSet<String>> graph = new HashMap();
        List<List<String>> res = new ArrayList();
        
        for(String str:wordList){
           graph.put(str, new HashSet());
        }
        
        bfs(distance, graph, beginWord, endWord, wordList);
        List<String> path = new ArrayList();
        dfs(distance, graph, res, path, endWord, beginWord, endWord, wordList);
        return res;
        
    }
    
   private void bfs(HashMap<String, Integer> distance, HashMap<String, HashSet<String>> graph, String beginWord, String endWord, Set<String> wordList){
        Queue<String> queue = new LinkedList();
        queue.offer(endWord);   //-----have to start from end, because have to keep shortest feature and visited in bfs-----
        distance.put(endWord, 0);
        while(!queue.isEmpty()){
            String tmp = queue.poll();
            for(String next:getWords(tmp, wordList)){
                graph.get(tmp).add(next);
                if(!distance.containsKey(next)){
                    distance.put(next, distance.get(tmp)+1);
                    queue.offer(next);
                }
            }
        }
    } 
    
    private void dfs(HashMap<String, Integer> distance, HashMap<String, HashSet<String>> graph, List<List<String>> res, List<String> path, String curt, String beginWord, String endWord, Set<String> wordList){
        path.add(0, curt);
        if(beginWord.equals(curt)){
            res.add(new ArrayList(path));
        }else{
            for(String next:graph.get(curt)){
                if(distance.containsKey(curt)&&distance.get(curt)+1==distance.get(next)){
                    dfs(distance, graph, res, path, next, beginWord, endWord, wordList);
                }
            }
        }
        path.remove(0);
    }
    
    private String replace(String cur, char c, int position){
        char[] ch = cur.toCharArray();
        ch[position] = c;
        return new String(ch);
    }
    
    private HashSet<String> getWords(String cur, Set<String> wordList){
        HashSet<String> res = new HashSet();
        for(int i=0; i<cur.length(); i++){
            for(char c='a'; c<='z'; c++){
                if(c==cur.charAt(i)) continue;
                String tmp = replace(cur, c, i);
                if(wordList.contains(tmp)&&!res.contains(tmp))  res.add(tmp);
            }
        }
        return res;
    }
}