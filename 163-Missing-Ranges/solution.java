public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList();
        
        int next = lower;
        for(int i=0; i<nums.length; i++){
            if(next>nums[i]){
                continue;
            }
            
            if(next==nums[i]){
                next = next+1;
                continue;     
            }
            
            res.add(getRange(next, nums[i]-1));
            
            next = nums[i]+1;
        }
        if(next<=upper){
            res.add(getRange(next, upper));
        }
        return res;
    }
    
    private String getRange(int n1, int n2){
        return (n1==n2)?String.valueOf(n1):String.format("%d->%d", n1, n2);
    }
}