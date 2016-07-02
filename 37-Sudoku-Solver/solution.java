public class Solution {
    int[] dX = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    int[] dY = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
    public void solveSudoku(char[][] board) {
        solver(board); 
    }
    
    private boolean solver(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]!='.'){
                    continue;
                }
                for(int k=1; k<=9; k++){
                    board[i][j] = (char)(k+'0');
                    if(isValid(board, i, j)&&solver(board)){
                        return true;
                    }
                    board[i][j] = '.';  //-------------think about backtracking here.----------------
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int a, int b){
        HashSet<Character> set = new HashSet(); 
        for(int j=0; j<9; j++){
            if(set.contains(board[a][j])){
                return false;
            }
             if(board[a][j]>'0' && board[a][j]<='9')
                contained.add(board[a][j]);
        }
        set.clear();
        for(int i=0; i<9; i++){
            if(set.contains(board[i][b])){
                return false;
            }
            if(board[i][b]>'0' && board[i][b]<='9')
                contained.add(board[i][b]);
        }
        
        set.clear();
        int startX = a/3*3+1;
        int startY = b/3*3+1;
        for(int k=0; k<9; k++){
            int nextX = startX+dX[k];
            int nextY = startY+dY[k];
            if(set.contains(board[nextX][nextY])){
                return false;
            }
             if(board[nextX][nextY]>'0' && board[nextX][nextY]<='9')
                contained.add(board[nextX][nextY]);
        }
        return true;
    }
}