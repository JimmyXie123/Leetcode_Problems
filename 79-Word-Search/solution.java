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
        boolean visited[][] = new boolean[m][n];
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
        if(index>=word.length()){
            System.out.println("i="+i+" j="+j+" index="+index);
            System.out.println("123");
            return true;
        }
        if(i<0||i>=m||j<0||j>=n){
            return false;
        }
        if(board[i][j]!=word.charAt(index)){
            return false;
        }
        board[i][j] = 'V';  //----------已访问过，同surrounded regions-----------
        boolean result = false;
        for(int k=0; k<4; k++){
            int nextX = i+dX[k];
            int nextY = j+dY[k];
            result = result||dfs(board, nextX, nextY, index+1, word);
        }
        board[i][j] = word.charAt(index); //---------backtrack!-----------------
        return result;
    }
}