public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1){
            return 0;
        }
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        //-----------DP from left to right--------------
        int len = prices.length;
        int min=prices[0];
        left[0]=0;
        for(int i=1; i<len; i++){
            min = Math.min(min, prices[i]);
            left[i]=Math.max(left[i-1], prices[i]-min);
        }
        
        //----------DP from right to left-----------
        int max = prices[len-1];
        right[len-1]=0;
        for(int i=len-2; i>=0; i++){
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i+1], max-prices[i]); 
        }
        
        int res = 0;
        for(int i=0; i<len; i++){
            res = Math.max(left[i]+right[i], res);
        }
        return res;
        
    }
}