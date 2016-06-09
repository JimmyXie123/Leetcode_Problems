public class Solution {
    private int Area(int[] height, int i, int j){
        return (j-i)*Math.min(height[i], height[j]);
    }
    public int maxArea(int[] height) {
        if(height==null||height.length<2){
            return 0;
        }
        int max = 0;
        for(int i=0; i<height.length-1; i++){
            for(int j=i+1; i<height.length; j++){
                if(Area(height, i, j)>max){
                    max = Area(height, i, j);
                }
            }
        }
        
        return max;
    }
}