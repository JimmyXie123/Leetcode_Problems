public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1, candidate2;
        int count1=0, count2=0;
        for(int i=0; i<nums.length; i++){
            if(count1==0){
                candidate1=nums[i];
                count1++;
            }else if(candidate1==nums[i]){
                count1++;
            }else if(count2==0){
                candidate2=nums[i];
                count2++;
            }else if(candidate2==nums[i]){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        
        count1=0, count2=0;
        for(int i=0; i<nums.length; i++){
            if(candidate1==nums[i]){
                count1++;
            }
            if(candidate2==nums[i]){
                count2++;
            }
        }
        
        List<Integer> result = new ArrayList();
        if(count1>nums.length/3){
            result.add(candidate1);
        }
        if(count2>nums.length/3){
            result.add(candidate2);
        }
    }
}