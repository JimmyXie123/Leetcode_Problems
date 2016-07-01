public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int ans = Integer.MIN_VALUE;
        
//-----------------three dimension enumeration with memoration, sick!------------------
        for(int i=0; i<n; i++){
            int[] sum = new int[m];
            for(int j=i; j<n; j++){
                int num = 0;
                TreeSet<Integer> set = new TreeSet();
                for(int p=0; p<m; p++){
                    sum[p] += matrix[p][j];
                    num += sum[p];
                    if(num<=k){
                        ans = Math.max(ans, num);
                    }
                    Integer tmp = set.ceiling(num-k);
                    if(tmp!=null){
                        ans = Math.max(ans, num-tmp);
                    }
                    set.add(num);
                }
            }
        }
        return ans;
    }
}