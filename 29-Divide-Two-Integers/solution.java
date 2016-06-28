public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return (dividend>=0)?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        
        if(dividend==0){
            return 0;
        }
        
        //---------------下面这个if注意：因为最小负比最大正多一位--------------------
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean isNegative = (dividend<0&&divisor>0)||(dividend>0&&divisor<0);
        //---------------这里的(long)不能少----------
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        
        int result = 0;
        while(a>=b){
            int shift = 1;
            while(a>=(b<<shift)){
                shift++;
            }
            a -= b<<(shift-1);
            result += 1<<(shift-1); 
        }
        
        return isNegative?-result:result;
        
    }
}