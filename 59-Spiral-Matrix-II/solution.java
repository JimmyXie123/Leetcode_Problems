public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n<=0){
            return matrix;
        }
        int end = n*n;
        int pointer = 1;
        int count = 0;
        while(count*2<n){
            for(int i=count; i<n-count; i++){
                matrix[count][i] = pointer++;
            }
            if(n-count*2==1){
                break;
            }
            for(int i=count+1; i<n-count; i++){
                matrix[i][n-count-1] = pointer++;
            }
            for(int i=n-count-2; i>=count; i--){
                matrix[n-count-1][i] = pointer++;
            }
            for(int i=n-count-2; i>count; i--){
                matrix[i][count] = pointer++;
            }
            count++;
        }
        
        return matrix;
    }
}