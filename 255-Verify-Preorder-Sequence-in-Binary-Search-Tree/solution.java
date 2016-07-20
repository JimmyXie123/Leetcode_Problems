public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack();
        int low = Integer.MIN_VALUE;
        for(int i:preorder){
            if(low>i){
                return false;
            }
            while(!stack.isEmpty()&&stack.peek()<i){
                low = stack.pop();
            }
            stack.push(i);
        }
        return true;
    }
}