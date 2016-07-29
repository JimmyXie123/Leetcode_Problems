public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int sign = 1;
        int num = 0;
        int result = 0;
        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(Character.isDigit(tmp)){
                num = num*10+(int)(tmp-'0');
            }else if(tmp=='+'){
                result += sign*num;
                sign = 1;
                num = 0;
            }else if(tmp=='-'){
                result += sign*num;
                sign = -1;
                num = 0;
            }else if(tmp=='('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }else if(tmp==')'){
                result += sign*num;
                num = 0;          //-----------remember---------------
                result *= stack.pop();
                result += stack.pop();
            }
        }
        
        result += sign*num;
        return result;
        
    }
}