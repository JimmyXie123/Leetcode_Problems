//---------think about when we must build nodes with neighbors, 这里必须有，不然回访太麻烦-----------
class Node{
    int inDegree;
    ArrayList<Integer> neighbors;
    public Node(){
        inDegree = 0;
        neighbors = new ArrayList();
    }
}

public class Solution {
    public String alienOrder(String[] words) {
        Node[] nodes = new Node[26];
        for(int i=0; i<26; i++){
            nodes[i] = new Node();
        }
        
        boolean[] happen = new boolean[26];
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++){
                happen[charToInt(words[i].charAt(j))] = true;
            }
        }
        
        for(int i=0; i<words.length-1; i++){
            int j=0;
            while(j<Math.min(words[i].length(), words[i+1].length())&&words[i].charAt(j)==words[i+1].charAt(j)){
                j++;
            }
            
            if(j==Math.min(words[i].length(), words[i+1].length())){
                continue;
            }
            
            nodes[charToInt(words[i].charAt(j))].neighbors.add(charToInt(words[i+1].charAt(j)));
            nodes[charToInt(words[i+1].charAt(j))].inDegree++;
        }
        
        Queue<Node> queue = new LinkedList();
        String res = "";
        for(int i=0; i<26; i++){
            if(nodes[i].inDegree==0&&happen[i]){
                queue.offer(nodes[i]);
                res += intToChar(i);
            }
        }
        while(!queue.isEmpty()){
            Node tmp = queue.poll();
            for(int i:tmp.neighbors){
                nodes[i].inDegree--;
                if(nodes[i].inDegree == 0){
                    queue.offer(nodes[i]);
                    res += intToChar(i);
                }
            }
        }
        
        for(int i=0; i<26; i++){
            if(nodes[i].inDegree>0){
                return "";
            }
        }
        
        return res;
    }
    
    private int charToInt(char c){
        return c-'a';
    }
    
    private char intToChar(int i){
        return (char)(i+'a');
    }
}