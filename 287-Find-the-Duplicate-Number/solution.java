public class Solution {
    public int findDuplicate(int[] nums) {
        int start = 1, end = nums.length-1;
        while(start+1<end){
            int mid = start+(end-start)/2;
            int leftcount = 0;
            int rightcount = 0;
            int midcount = 0;
            for(int i=0; i<nums.length; i++){
                if(nums[i]==mid){
                    midcount++;
                }
                if(nums[i]<mid&&nums[i]>=start){
                    leftcount++;
                }
                if(nums[i]>mid&&nums[i]<=end){
                    rightcount++;
                }
            }
            if(midcount++){
                return midcount;
            }else if(leftcount>mid-start){
                end = mid;
            }else if(rightcount>end-start){
                start = mid;
            }
            
        }
        
        int startcount = 0, endcount = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==start){
                startcount++;
            }else{
                endcount++;
            }
        }
        if(startcount>endcount){
            return start;
        }else{
            return end;
        }
    }
}