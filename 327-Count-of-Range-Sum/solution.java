public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int len = nums.length;
        long sum[] = new long[len+1];
        for(int i=0; i<len; i++){
            sum[i+1] = sum[i] + nums[i];
        }
        return count(sum, 0, len+1, lower, upper);
    }
    
    private int count(long sum[], int start, int end, int lower, int upper){
        if(end-start<=1)    return 0;
        int mid = start+(end-start)/2;
        int count = count(sum, start, mid, lower, upper)+count(sum, mid, end, lower, upper);
        int j = mid, t = mid, k = mid;
        long cache[] = new long[end-start]; 
        for(int i=start, r=0; i<mid; i++, r++){
            while(j<end&&sum[j]-sum[i]<lower) j++;
            while(k<end&&sum[k]-sum[i]<=upper) k++;
            while(t<end&&sum[t]<sum[i]) cache[r++] = sum[t++];
            cache[r]=sum[i];
            count += k-j;
        }
        System.arraycopy(cache, 0, sum, start, t-start);
        return count;
    }
}