public class Solution {
    public int integerBreak(int n) {
        int res[] = new int[n+1];
        res[1] = 1;
        for(int i=2; i<=6&&i<=n; i++){
            res[i] = i/2*(i-i/2);
        }
        
        for(int i=7; i<=n; i++){
            res[i] = Math.max(res[i-2]*2, res[i-3]*3);
        }
        
        return res[n];
        
    }
}