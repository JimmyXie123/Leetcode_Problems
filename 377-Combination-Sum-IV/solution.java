public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int res[] = new int[target+1];
        for(int i=1; i<=target; i++){
            for(int num:nums){
                if(i<num){
                    continue;
                }else if(i==num){
                    res[i]++;
                }else{
                    res[i] += res[i-num];
                }
            }
        }
        return res[target];
    }
}