class Node{
    boolean hasWord;
    Node[] kids;
    public Node(){
        hasWord = false;
        kids = new Node[26];
    }
}

public class Solution {
    Node root = new Node();
    int dX[] = {-1, 1, 0, 0};
    int dY[] = {0, 0, -1, 1};
    int m, n;
    private void AddWord(String word){
        Node traverse = root;
        for(int i=0; i<word.length(); i++){
            if(traverse.kids[word.charAt(i)-'a']==null){
                traverse.kids[word.charAt(i)-'a'] = new Node();
            }
            traverse = traverse.kids[word.charAt(i)-'a'];
        }
        traverse.hasWord = true;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList();
        if(words.length<=0||board==null||board.length==0||board[0].length==0){
            return res;
        }
        m = board.length;
        n = board[0].length;
        for(String word: words){
            AddWord(word);
        }
        //System.out.println(root.kids[4].kids[0].kids['t'-'a'].hasWord);
        
        HashSet<String> set = new HashSet();
        String path = "";
        boolean visited[][] = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                helper(board, i, j, root, res, path, set, visited);
            }
        }
        
        return res;
        
    }
    
    private void helper(char[][] board, int i, int j, Node now, List<String> res, String path, HashSet<String> set, boolean[][] visited){
        if(now!=null&&now.hasWord&&!set.contains(path)){
            res.add(path);
            set.add(path);
        }
        if(i<0||i>=m||j<0||j>=n||visited[i][j]==true||now==null){
            return;
        }
        
        path = path+board[i][j];
        
        visited[i][j] = true;
        for(int k=0; k<4; k++){
            int nextX = i+dX[k];
            int nextY = j+dY[k];
            helper(board, nextX, nextY, now.kids[board[i][j]-'a'], res, path, set, visited);
        }
        visited[i][j] = false;
    }
}