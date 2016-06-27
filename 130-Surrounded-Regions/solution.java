//------------DFS会爆栈-----------------
public class Solution {
    int[] dX = {-1,0,0,1};
    int[] dY = {0,-1,1,0};
    int row, col;
    private static final char FREE = 'F';
    private static final char VISITED = 'V';
    
    public void solve(char[][] board) {
        if(board==null||board.length==0){
            return;
        }
        row = board.length;
        if(board[0]==null||board[0].length==0){
            return;
        }
        col = board[0].length;
        
        for(int i=0; i<row; i++){
            bfs(board, i, 0);
            bfs(board, i, col-1);
        }
        
        for(int j=0; j<col; j++){
            bfs(board, 0, j);
            bfs(board, row-1, j);
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='F'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    private void bfs(char[][] board, int i, int j){
        if(board[i][j]!='O'){
            return;
        }
        
        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(i, j));
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            board[temp.x][temp.y] = FREE;
            for(int k=0; k<4; k++){
                int nextX = temp.x+dX[k];
                int nextY = temp.y+dY[k];
                if(nextX>=0 && nextX<row && nextY>=0 && nextY<col){
                    if(board[nextX][nextY]=='O'){
                        //board[nextX][nextY] = VISITED; //board[nextX][nextY] = FREE;
//--------上句话意义在于，虽然某个队列中的点最终会被free，但是他在队列里头等待的时候，还有其他的点可能访问他，然后他又会被加进队列。其实直接设成FREE就好。--------------
                        queue.offer(new Node(nextX, nextY));
                    }
                }
            }
        }
        
    }
    
    private class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
}