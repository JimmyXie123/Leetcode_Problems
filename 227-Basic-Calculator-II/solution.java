public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int len = s.length();
        char sign = '+';
        int num = 0;                 //----------pay attention to this num--------------------------
        for(int i=0; i<len; i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10 + s.charAt(i) - '0';
            }
            if((!Character.isDigit(s.charAt(i))&&s.charAt(i)!=' ')||i==len-1){
                if(sign=='+'){
                    stack.push(num);
                }else if(sign=='-'){
                    stack.push(-num);
                }else if(sign=='*'){
                    stack.push(stack.pop()*num);
                }else if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}