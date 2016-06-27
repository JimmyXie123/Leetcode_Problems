public class Solution {
    int[] dX = {-1, 0, 0, 1};
    int[] dY = {0, 1, -1, 0};
    int m, n;
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0){
            return false;
        }
        m = board.length;
        n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, int index, String word){
        if(index>=word.length){
            return true;
        }
        if(board[i][j]!=word.charAt(index)){
            return false;
        }
        for(int k=0; k<4; k++){
            int nextX = i+dX[k];
            int nextY = j+dY[k];
            if(nextX<m&&nextX>=0&&nextY<n&&nextY>=0&&dfs(board, nextX, nextY, index+1, word)==true){
                return true;
            }
        }
        return false;
    }
}