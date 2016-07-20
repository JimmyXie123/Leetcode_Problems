public class Solution {
    public void wiggleSort(int[] nums) {
        int mid = partition(nums, 0, nums.length-1, (nums.length+1)/2);
        int ans[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = mid;
        }
        int l, r;
        if(nums.length%2==0){
            l = nums.length-2;                                  //----   if l=0, r= nums.length-1
            r = 1;                                              //--------[4,5,5,6]-->[4,5,5,6]
            for(int i=0; i<nums.length; i++){                   //-----  if l=nums.length-2, r=0
                if(nums[i]>mid){                                //---------[1,5,1,1,6,4]-->[4,1,5,1,6,1]
                    ans[r] = nums[i];
                    r = r+2;
                }else if(nums[i]<mid){
                    ans[l] = nums[i];
                    l = l-2;
                }
            }
        }else{
            l=0;                                                //------if l=0, r=nums.length-2
            r = nums.length-2;                                  //--------[1,1,2,1,2,2,1]-->[1,1,2,1,2,1,2]
            for(int i=0; i<nums.length; i++){
                if(nums[i]>mid){
                    ans[r] = nums[i];
                    r = r-2;
                }else if(nums[i]<mid){
                    ans[l] = nums[i];
                    l = l+2;
                }
            }
        }
        
        for(int i=0; i<nums.length; i++){
            nums[i] = ans[i];
        }
        
    }
    
    private int partition(int[] nums, int left, int right, int rank){
        int pivot = nums[left];
        int l=left;
        int r=right;
        while(l<r){
            while(l<r&&nums[r]>=pivot){
                r--;
            }
            nums[l] = nums[r];
            while(l<r&&nums[l]<=pivot){
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = pivot;
        if(l+1==rank){
            return pivot;
        }else if(l+1<rank){
            return partition(nums, l+1, right, rank);
        }else{
            return partition(nums, left, l-1, rank);
        }
    }
}