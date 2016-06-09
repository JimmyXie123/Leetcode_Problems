public class Solution {
    private int Area(int[] height, int i, int j){
        return (j-i)*(Math.min(height[i], height[j]));
    }
    public int maxArea(int[] height) {
        if(height==null||height.length<2){
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while(left<=right){
            max = Math.max(max, Area(height, left, right));
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        
        
        return max;
    }
}