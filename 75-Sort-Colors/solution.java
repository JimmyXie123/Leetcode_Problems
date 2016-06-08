public class Solution {
    public void sortColors(int[] nums) {
        //int[] result = new int[nums.length];
        if(nums.length<2){
            return;
        }
        int mid = nums.length/2;
        //System.out.println(mid);
        int[] left = new int[mid];
        int[] right = new int[nums.length-mid];
        for(int i=0; i<mid; i++){
            left[i] = nums[i];
        }
        for(int i=mid; i<nums.length; i++){
            right[i-mid] = nums[i];
        }
        
        sortColors(left);
        /*
        if(left.length == 3){
            System.out.println();
            for(int i:left){
                System.out.println(i);
            }
        }
        */
        sortColors(right);
        /*
        if(right.length == 3){
            System.out.println();
            for(int i:right){
                System.out.println(i);
            }
        }*/
        merge(left, right, nums);
        /*
        if(nums.length == 3){
            System.out.println();
            for(int i:result){
                System.out.println(i);
            }
        }
        */
        
        
    }
    
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
        
    }
}