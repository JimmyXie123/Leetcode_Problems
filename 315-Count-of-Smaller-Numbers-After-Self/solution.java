public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sorted = new ArrayList();
        Integer[] res = new Integer[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            int index = findIndex(sorted, nums[i]);
            sorted.add(index, nums[i]);
            res[i] = new Integer(index);
        }
        return Arrays.asList(res);
    }
    
    private int findIndex(List<Integer> sorted, int num){     
        //--------strictly less than, so no "==" case in binary search--------------
        if(sorted.size()==0)    return 0;         
        int start = 0;
        int end = sorted.size()-1;
        if(num<sorted.get(start))  return 0;
        if(num>sorted.get(end))  return end+1;
        while(start+1<end){
            int mid = start+(end-start)/2;
            if(sorted.get(mid)<num){
                start = mid;         
            }else{
                end = mid;
            }
        }
        if(num==sorted.get(start)){
            return start;
        }else{
            return end;
        }     
    }
}