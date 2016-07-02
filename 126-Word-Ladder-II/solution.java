public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ladders = new ArrayList();
        HashMap<String, ArrayList<String>> graph = new HashMap();
        HashMap<String, Integer> distance = new HashMap();
        
        for(String str:wordList){
            graph.put(str, new ArrayList());
        }
        
        bfs(ladders, graph, distance, beginWord, wordList);
        List<String> path = new ArrayList();
        dfs(ladders, path, graph, distance, beginWord, endWord);
        return ladders;
        
    }
    
    private void bfs(List<List<String>> ladders, HashMap<String, ArrayList<String>> graph, HashMap<String, Integer> distance, String start, Set<String> wordList){
        Queue<String> queue = new LinkedList();
        queue.offer(start);
        distance.put(start, 0);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                String crt = queue.poll();
                for(String next:getWords(crt, wordList)){
                    graph.get(next).add(crt);
                    if(!distance.containsKey(next)){
                        distance.put(next, distance.get(crt)+1);
                        queue.offer(next);
                    }
                }
            }
            
        }
    }
    
    private void dfs(List<List<String>> ladders, List<String> path, HashMap<String, ArrayList<String>> graph, HashMap<String, Integer> distance, String crt, String end){
        path.add(crt);
        if(crt.equals(end)){
            //Collections.reverse(path);
            ladders.add(new ArrayList(path));
            //Collections.reverse(path);
        }else{
            for(String next:graph.get(crt)){
                if(distance.containsKey(next)&&distance.get(next)==distance.get(crt)+1){
                    dfs(ladders, path, graph, distance, next, end);
                }
            }
        }
        path.remove(path.size()-1);
    }
    
    private String replace(String word, int index, char c){
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    private ArrayList<String> getWords(String word, Set<String> wordList){
        ArrayList<String> neighbors = new ArrayList();
        for(int i=0; i<word.length(); i++){
            for(char c='a'; c<='z'; c++){
                if(c==word.charAt(i)){
                    continue;
                }
                String temp = replace(word, i, c);
                if(wordList.contains(temp)){
                    neighbors.add(temp);
                }
            }
        }
        
        return neighbors;
    }
}