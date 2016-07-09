public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap(); 
        map.put(0, -1);
        int max =0;
        for(int i=0; i<nums.length; i++){
            sum+= nums[i];
            if(map.containsKey(sum-k)){
                max = Math.max(max, i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){         //------注意这个判断条件----------
                map.put(sum, i);
            }
        }
        return max;
    }
}