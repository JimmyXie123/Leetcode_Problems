public class Solution {
    public void sortColors(int[] nums) {
/*
        if(nums.length<2){
            return;
        }
        int mid = nums.length/2;
        int[] left = new int[mid];
        int[] right = new int[nums.length-mid];
        for(int i=0; i<mid; i++){
            left[i] = nums[i];
        }
        for(int i=mid; i<nums.length; i++){
            right[i-mid] = nums[i];
        }
        
        sortColors(left);
        sortColors(right);
        merge(left, right, nums);
*/
        if(nums==null||nums.length<2){
            return;
        }
        int pl = 0;
        int pr = nums.length-1;
        int i=0;
        while(i<=pr){
            if(nums[i]==2){
                swap(nums, i, pr);
                pr--;
            }else if(nums[i]==1){
                i++;
            }else{
                swap(nums, i, pl);
                i++;
                pl++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
    private void merge(int[] left, int[] right, int[] result){
        //System.out.println("到了吗");
        int i=0, j=0, l=0;
        while(i<left.length&&j<right.length){
            if(left[i]<=right[j]){
                result[l] = left[i];
                
                l++; 
                i++;
            }else{
                
                result[l] = right[j];
                //System.out.println(result[0]);
                l++;
                j++;
            }
        }
        while(i>=left.length&&j<right.length){
            
            result[l] = right[j];
            l++;
            j++;
        }
        while(i<left.length&&j>=right.length){
           
            result[l] = left[i];
             //System.out.println(result[1]);
            l++;
            i++;
        }
        
    }*/
}