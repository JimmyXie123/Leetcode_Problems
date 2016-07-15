public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums==null){
            return new ArrayList();
        }
        int len = nums.length;
        Arrays.sort(nums);
        int count[] = new int[len];
        int parent[] = new int[len];
        
        int max = 0, start=len-1;
        for(int i=len-1; i>=0; i--){
            for(int j=i; j<len; j++){
                if(nums[j]%nums[i]==0&&count[j]+1>count[i]){
                    count[i] = count[j]+1;
                    parent[i] = j;
                }        
            }
            max = Math.max(max, count[i]);
            if(max==count[i]){
                start = i;
            }
        }
        
        List<Integer> res = new ArrayList();
        for(int i=0; i<max; i++){
            res.add(nums[start]);
            start = parent[start];
        }
        return res;
        
    }
}