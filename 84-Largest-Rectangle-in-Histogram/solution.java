public class Solution {
    /*DP: 
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0){
            return 0;
        }
        int result[][] = new int[heights.length][2];
        for(int i=0; i<heights.length; i++){
            if(i==0){
                result[0][0]=heights[0];
                result[0][1]=heights[0];
            }else{
                result[i][0] = Math.min(heights[i], result[i-1][0]);
                result[i][1] = Math.max(result[i-1][1], result[i][0]*(i+1));
            }
        }
        return result[heights.length-1][1];
        */
    /* two pointers
        int left = 0;
        int right = heights.length-1;
        int max = 0;
        while(left<=right){
            max = Math.max(max, (right-left+1)*Math.min(heights[left], heights[right]));
            if(heights[left]<=heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;*/
    public int largestRectangleArea(int[] heights){
        if(heights==null||heights.length==0){
            return 0;
        }
        Stack<Integer> stack = new Stack();
        int max = 0;
        for(int i=0; i<=heights.length; i++){
            int curt = (i==heights.length) ? -1:heights[i];
            while(!stack.isEmpty()&&curt<=heights[stack.peek()]){
                int h = heights[stack.pop()];
                int w = (stack.isEmpty())? i:i-stack.peek()-1;
                max = Math.max(max, w*h);
            }
            stack.push(i);
        }
        return max;
    }
}