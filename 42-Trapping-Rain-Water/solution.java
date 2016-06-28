public class Solution {
    public int trap(int[] height) {
        if(height==null){
            return 0;
        }
        int left = 0;
        int right = height.length-1;
        int smaller = 0;
        int res = 0;
        while(left<right){
            if(height[left]<height[right]){
                smaller = height[left];
                while(left<right&&height[left]<=smaller){
                    res += smaller-height[left];
                    left++;
                }
            }else{
                smaller = height[right];
                while(left<right&&height[right]<=smaller){
                    res += smaller-height[right];
                    right--;
                }
            }
        }
        return res;
    }
}