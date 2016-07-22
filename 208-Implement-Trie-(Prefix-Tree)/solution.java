class TrieNode {
    HashMap<Character, TrieNode> kids;
    boolean hasword;
    // Initialize your data structure here.
    public TrieNode() {
        this.kids = new HashMap();
        this.hasword = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode traverse = root;
        for(int i=0; i<word.length(); i++){
            Character c = word.charAt(i);
            if(!traverse.kids.containsKey(c)){
                traverse.kids.put(c, new TrieNode());
            }
            traverse = traverse.kids.get(c);
        }
        traverse.hasword = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode now = root;
        for(int i=0; i<word.length(); i++){
            Character c = word.charAt(i);
            if(!now.kids.containsKey(c)){
                return false;
            }
            now = now.kids.get(c);
        }
        return now.hasword;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode now = root;
        for(int i=0; i<prefix.length(); i++){
            Character c = prefix.charAt(i);
            if(!now.kids.containsKey(c)){
                return false;
            }
            now = now.kids.get(c);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");