public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack();
        long last = Long.MIN_VALUE;
        for(int i:preorder){
            if(i<last)   return false;
            while(!stack.isEmpty()&&stack.peek()<i){
                last = stack.pop();
            }
            
            stack.push(i);
        }
        
        return true;
    }
}