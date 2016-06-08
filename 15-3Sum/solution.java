public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        HashMap<Integer, int[]> map = new HashMap();
        //List<Integer> path = new ArrayList();
        if(nums==null){
            return result;
        }
        //Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(map.containsKey(0-nums[j])){
                    int[] temp = map.get(-nums[j]);
                    List<Integer> path = new ArrayList();
                    path.add(temp[0]);
                    path.add(temp[1]);
                    path.add(nums[j]);
                    result.add(path);
                }else{
                    int[] temp = new int[2];
                    temp[0] = nums[i];
                    temp[1] = nums[j];
                    map.put(nums[i]+nums[j], temp);
                }
                
            }
        }
        
        return result;
        
        
    }
}