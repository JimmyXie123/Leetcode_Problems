public class Solution {
    public int longestValidParentheses(String s) {
        int accumlen = 0;
        int res = 0;
        Stack<Integer> stack = new Stack();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    accumlen = 0;
                }else{
                    int matchedPos = stack.pop();
                    int maxLength = i-matchedPos+1;
                
                
                    if(stack.isEmpty()){
                        accumlen += maxLength;
                        maxLength = accumlen;
                    }else{
                        maxLength = i-stack.peek();
                    }
                    res = Math.max(res, maxLength);
                }
            }
        }
        return res;
    }
}