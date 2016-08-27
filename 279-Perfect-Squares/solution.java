public class Solution {
    public int numSquares(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int[] res = new int[n+1];
        res[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=1; j*j<=i; j++){
                if(i-j*j>=0){
                    if(res[i]==0) res[i]=res[i-j*j]+1;
                    else res[i] = Math.min(res[i], res[i-j*j]+1);
                }
            }
        }
        
        return res[n];
    }
}