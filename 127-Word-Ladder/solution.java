public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(wordList==null){
            return 0;
        }
        
        System.out.println(wordList.contains(endWord));
        HashSet<String> graph = new HashSet();
        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        graph.add(beginWord);
        
        int length = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            length++;
            for(int i=0; i<size; i++){
                String word = queue.poll();
                for(String n:getWords(word, wordList)){
                    if(graph.contains(n)){
                        continue;
                    }else{
                        if(n.equals(endWord)){
                            return length;
                        }
                    }
                    
                    queue.offer(n);
                    graph.add(n);
                }
            }
        }
        
        return 0;//--------no transformation sequence return 0;
        
    }
    
    private String replace(String word, int i, char c){
        char[] result = word.toCharArray();
        result[i] = c;
        return new String(result);
    }
    
    private ArrayList<String> getWords(String word, Set<String> WordList){
        ArrayList<String> result = new ArrayList();
        for(int i=0; i<word.length(); i++){
            for(char c='a'; c<='z'; c++){
                if(word.charAt(i)==c){
                    continue;
                }
                String temp = replace(word, i, c);
                if(WordList.contains(temp)){
                    result.add(temp);
                }
            }
        }
        
        return result;
    } 
}