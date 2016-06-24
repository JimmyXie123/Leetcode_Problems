public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return;
        }
        int n = matrix.length;
        int sep = (n+1)/2;
        for(int i=0; i<sep; i++){
            for(int j=0; j<sep; j++){
                move(matrix, i, j, n);
            }
        }
    }
    
    private void move(int[][] matrix, int i, int j, int n){
        int[][] xy = getXY(matrix, i, j, n);
        int temp = matrix[xy[0][3]][xy[1][3]];
        for(int i=3; i>=1; i--){
            matrix[xy[0][i]][xy[1][i]] = matrix[xy[0][i-1]][xy[1][i-1]];
        }
        matrix[xy[0][0]][xy[1][0]] = temp;
    }
    
    private int[][] getXY(int i, int j, int n){
        int[][] result = new int[2][4];
        result[0][0] = i;
        result[1][0] = j;
        result[0][1] = j;
        result[1][1] = n-i-1;
        result[0][2] = n-i-1;
        result[1][2] = n-j-1;
        result[0][3] = n-j-1;
        result[1][3] = i;
        return result;
    }
}