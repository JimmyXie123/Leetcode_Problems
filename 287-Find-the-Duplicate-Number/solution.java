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
            if(midcount>1){
                return mid;
            }else if(leftcount>mid-start){
                System.out.println("123");
                end = mid;
            }else if(rightcount>end-start){
                start = mid;
            }
            
        }
        
        int startcount = 0, endcount = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==start){
                startcount++;
            }/*else{
                endcount++;     //----------并不是else，写else注意是不是应该是else if-----------
            }*/
            if(nums[i]==end){
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