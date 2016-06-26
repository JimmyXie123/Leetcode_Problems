public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        for(int i=1; i<=nums.length; i++){
            sum[i] = sum[i-1]+nums[i-1];
        }
        int res = 0;
        int low_pos=-1;
        for(int i=1; i<=nums.length; i++){
            for(int j=0; j<i; j++){
                if(low_pos!=-1&&j<=low_pos){
                    continue;
                }
                if(sum[i]-sum[j]>=s){
                    if(res==0){
                        res = i-j;
                    }else if(i-j>=res){
                        continue;
                    }else{
                        low_pos = j;
                        res = i-j;
                    }
                }
            }
        }
        return res;
    }
}