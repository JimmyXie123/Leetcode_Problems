public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder==null||preorder.length==0){
            return true;
        }
        Stack<Integer> stack = new Stack();
        int last = Integer.MIN_VALUE;
        for(int i:preorder){
            if(i<last){
                    return false;
            }
            while(!stack.isEmpty()&&stack.peek()<i){
                last = stack.pop();
            }
            stack.push(i);
        }
        return true;
    }
}