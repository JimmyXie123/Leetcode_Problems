public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int[] sum = new int[m];
            for(int j=i; j<n; j++){
                int num = 0;
                TreeSet<Integer> set = new TreeSet();
                for(int k=0; k<m; k++){
                    sum[k] += matrix[k][j];
                    num += sum[k];
                    if(num<=k){
                        ans = Math.max(ans, num);
                    }
                    Integer i = set.ceiling(num-k);
                    if(i!=null){
                        ans = Math.max(ans, num-i);
                    }
                    set.add(num);
                }
            }
        }
        return ans;
    }
}