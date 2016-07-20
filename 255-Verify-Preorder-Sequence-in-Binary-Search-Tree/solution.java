public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder==null||preorder.length==0){
            return true;
        }
        Stack<Integer> stack = new Stack();
        int low = Integer.MIN_VALUE;
        for(int i:preorder){
            if(i<low){
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