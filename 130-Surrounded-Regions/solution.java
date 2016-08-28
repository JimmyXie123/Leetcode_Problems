public class Solution {
    int dX[] = {-1, 0, 0, 1};
    int dY[] = {0, -1, 1, 0};
    int m, n;
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0) return;
        m = board.length;
        n = board[0].length;
        
        UnionFind uf = new UnionFind(m*n);
        uf.cnt[m*n] = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O')  uf.cnt[getNum(i, j)] = 1;
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O'&&(i==0||i==m-1||j==0||j==n-1)) {
                    uf.union(getNum(i,j), m*n);
                }
                if(i+1<m&&board[i][j]=='O'&&board[i+1][j]=='O') uf.union(getNum(i, j), getNum(i+1, j));
                if(j+1<n&&board[i][j+1]=='O'&&board[i][j]=='O') uf.union(getNum(i, j), getNum(i, j+1));
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O'&&uf.find(getNum(i, j))!=uf.find(m*n))  board[i][j] = 'X';
            }
        }
        
        
        
    }
    
    private int getNum(int x, int y){
        return x*n+y;
    }
    
    private boolean isBoarder(int x, int y){
        if(x==0||x==m-1||y==0||y==n-1)  return true;
        else return false;
    }
}

class UnionFind{
    HashMap<Integer, Integer> map = new HashMap();
    int[] cnt;
    public UnionFind(int n){
        cnt = new int[n+1];
        for(int i=0; i<=n; i++){
            map.put(i, i);
        }
    }
    
    public int find(int x){
        int parent = x;
        while(parent!=map.get(parent)){
            parent = map.get(parent);
        }
        
        while(parent!=map.get(x)){
            int tmp = map.get(x);
            map.put(x, parent);
            x = tmp;
        }
        return parent;
    }
    
    public void union(int x, int y){
        int parent_x = find(x);
        int parent_y = find(y);
        if(parent_x!=parent_y){
            if(cnt[parent_x]<cnt[parent_y]) map.put(parent_x, parent_y);
            else map.put(parent_y, parent_x);
        }
    }
}