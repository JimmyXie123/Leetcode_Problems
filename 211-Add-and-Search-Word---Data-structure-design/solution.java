class Node{
    HashMap<Character, Node> kids;
    boolean hasWord;
    public Node(){
        kids = new HashMap();
        hasWord = false;
    }
}

public class WordDictionary {
    Node root = new Node();
    // Adds a word into the data structure.
    public void addWord(String word) {
        Node now = root;
        for(int i=0; i<word.length(); i++){
            Character tmp = word.charAt(i);
            if(!now.kids.containsKey(tmp)){
                now.kids.put(tmp, new Node());
            }
            now = now.kids.get(tmp);
        }
        now.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word, 0, root);
    }
    
    private boolean find(String word, int index, Node node){
        if(word.length()==index){
            if(word.length()==0){
                return true;
            }else{
                return false;
            }
        }
        
        Character c = word.charAt(index);
        if(node.kids.containsKey(c)){
            if(index == word.length()-1&&node.kids.get(c).hasWord){
                return true;
            }
            return find(word, index+1, node.kids.get(c));
        }else if(c=='.'){
            for(Map.Entry<Character, Node> entry:node.kids.entrySet()){
                if(word.length()==index+1&&entry.getValue().hasWord){
                    return true;
                }
                if(find(word, index+1, entry.getValue())){
                    return true;
                }
            }
            return false;
        }else{
            return false;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");