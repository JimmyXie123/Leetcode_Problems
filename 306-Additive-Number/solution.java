import java.math.BigInteger;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for(int i=1; i<=len/2; i++){
            if(num.charAt(0)=='0'&&i>1) return false;
            String x1 = num.substring(0, i);
            for(int j=1; Math.max(i, j)<=len-i-j; j++){
                if(num.charAt(i)=='0'&&j>1) break;
                String x2 = num.substring(i, i+j);
                if(isValid(new BigInteger(x1), new BigInteger(x2), i+j, num))   return true;
            }
        }
        return false;
    }
    
    private boolean isValid(BigInteger x1, BigInteger x2, int start, String num){
        if (start == num.length()) return true;
        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String sum = x2.toString();
        System.out.println(sum);
        return num.startsWith(sum, start)&&isValid(x1, x2, start+sum.length(), num);
    }
}