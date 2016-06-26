public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList();
        if(nums==null){
            return res;
        }
        int slow = 0;
        int fast = 0;
        while(fast<nums.length){
            if(fast!=nums.length-1&&nums[fast]+1==nums[fast+1]){
                fast++;
                continue;
            }else{
                res.add(builder(nums, slow, fast));
                fast++;
                slow = fast;
            }
        }
        return res;
    }
    
    private String builder(int[] nums, int start, int end){
        String ele = new String();
        if(start==end){
            ele += nums[start];
        }else{
            ele = nums[start]+"->"+nums[end];
        }
        return ele;
    }
}