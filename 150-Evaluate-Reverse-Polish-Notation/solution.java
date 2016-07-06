public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        String operators = "+-*/";
        for(String token:tokens){
            if(!operators.contains(token)){
                stack.push(Integer.valueOf(token));
                continue;
            }
            int latter = stack.pop();
            int former = stack.pop();
            if(token.equals("+")){
                stack.push(former+latter);
            }else if(token.equals("-")){
                stack.push(former-latter);
            }else if(token.equals("*")){
                stack.push(former*latter);
            }else{
                stack.push(former/latter);
            }
        }
        return stack.pop();
    }
}