public class WordDictionary {
    Node root = new Node();
    // Adds a word into the data structure.
    public void addWord(String word) {
        addWord(word, 0, root);
    }
    
    private void addWord(String word, int index, Node now){
        int idx = word.charAt(index)-'a';
        if(now.kids[idx]==null){
            now.kids[idx] = new Node();
        }
        
        if(index==word.length()-1){
            now.kids[idx].hasWord = true;
            return;
        }
        
        addWord(word, index+1, now.kids[idx]);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    private boolean search(String word, int index, Node now){
        if(word.length()==index){
            if(word.length()==0){
                return true;
            }else{
                return false;
            }
        }
        int idx = word.charAt(index) - 'a';
        if(idx>=0&&idx<26&&now.kids[idx]!=null){
            if(index==word.length()-1&&now.kids[idx].hasWord){
                return true;
            }
            return search(word, index+1, now.kids[idx]);
        }else if(word.charAt(index)=='.'){
            for(int i=0; i<26; i++){
                if(index==word.length()-1&&now.kids[i]!=null&&now.kids[i].hasWord){
                    return true;
                }
                if(now.kids[i]!=null&&search(word, index+1, now.kids[i])){
                    return true;
                }
            }
            return false;
        }else{
            return false;
        }
    }
}

class Node{
    boolean hasWord;
    Node[] kids;
    public Node(){
        this.hasWord = false;
        this.kids = new Node[26];
    }
}
// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");