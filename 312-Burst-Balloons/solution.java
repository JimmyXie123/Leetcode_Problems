public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] res = new int[n+2][n+2];
        int[] iNums = new int[n+2];
        iNums[0] = 1;
        iNums[n+1] = 1;
        for(int i=0; i<n; i++){
            iNums[i+1] = nums[i];
        }
        
        for(int k=2; k<n+2; k++){
            for(int left=0; left<n-k+2; left++){
                int right = left + k;
                for(int i=left+1; i<right; i++){
                    res[left][right] = Math.max(res[left][right], iNums[left]*iNums[i]*iNums[right]+
                    res[left][i]+res[i][right]);
                }
            }
        }
        return res[0][n+1];
    }
}