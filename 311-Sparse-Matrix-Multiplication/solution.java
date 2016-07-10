public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A==null||B==null||A.length==0||B.length==0){
            return new int[0][0];
        }
        int m = A.length; int n = B.length; int l=B[0].length;
        
        int[][] res = new int[m][l];
        
        for(int i=0; i<m; i++){
            for(int k=0; k<n; k++){
                if(A[i][k]!=0){
                    for(int j=0; j<l; j++){
                        if(B[k][j]!=0){
                            res[i][j] += A[i][k]*B[k][j];
                        }
                    }
                }
            }
        }
        return res;
    }
}