public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        Stack<String> stack = new Stack();
        for(String str:strs){
            while(str.equals("#")&&!stack.isEmpty()&&stack.peek().equals("#")){
                stack.pop();
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
            stack.push(str);
        }
        return stack.size()==1&&stack.peek().equals("#");
    }
}