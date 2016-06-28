public class Solution {
    public int trap(int[] height) {
        if(height==null||height.length==0){
            return 0;
        }
        Stack<Integer> stack = new Stack();
        
        int result = 0;
        for(int i=0; i<=height.length; i++){
            if(i==0){
                stack.push(i);
                continue;
            }
            int curt = (i==height.length)?Integer.MAX_VALUE:height[i];
            while(!stack.isEmpty()&&height[stack.peek()]<curt){
                Integer num = stack.pop();
                if(num.intValue()==height.length){
                    break;
                }
                int max = 0;
                if(!stack.isEmpty()){
                    int max_height1 = height[stack.peek()];
                    int max_height2 = height[i];
                    int temp = Math.min(max_height1, max_height2);
                    for(int k=stack.peek()+1; k<i; k++){
                        max = temp-height[k];
                    }
                }
                result = Math.max(max, result);
            }
            stack.push(i);
        }
        return result;
    }
}