public class Solution {
    int dX[] = {-1, 0, 0, 1, 1, -1, -1, 1};
    int dY[] = {0, -1, 1, 0, -1, 1, -1, 1};
    //-----1:live->live, 2:live->dead, 3:dead->dead  4:dead->live--------
    public void gameOfLife(int[][] board) {
        if(board==null||board.length==0){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int live = count(board, row, col, i, j);
                board[i][j] = judge(board, i, j, live);
            }
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(board[i][j]==2||board[i][j]==3){
                    board[i][j] = 0;
                }else{
                    board[i][j] = 1;
                }
            }
        }
        
        
    }
    
    private int judge(int[][] board, int i, int j, int live){
        if(board[i][j]==1||board[i][j]==2){
            if(live==2||live==3){
                return 1;
            }else{
                return 2;
            }
        }else{
            if(live==3){
                return 4;
            }else{
                return 3;
            }
        }
    }
    
    private int count(int[][] board, int row, int col, int i, int j){
        int sum = 0;
        for(int k=0; k<8; k++){
            int nextX = i+dX[k];
            int nextY = j+dY[k];
            if(nextX>=0&&nextX<row&&nextY>=0&&nextY<col){
                if(board[nextX][nextY]==1||board[nextX][nextY]==2){
                    sum++;
                }
            }
        }
        return sum;
    }
}