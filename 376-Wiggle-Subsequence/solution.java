public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int f[] = new int[nums.length];
        int d[] = new int[nums.length];
        Arrays.fill(f, 1);
        Arrays.fill(d, 1);
        int res = 1;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    f[i] = Math.max(f[i], d[j]+1);
                    res = Math.max(res, f[i]);
                }else if(nums[i]<nums[j]){
                    d[i] = Math.max(d[i], f[j]+1);
                    res = Math.max(res, d[i]);
                }
            }
        }
        return res;
        
    }
}