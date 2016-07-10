public class Solution {
    public String multiply(String num1, String num2) {
        if(num1==null||num2==null){
            return null;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int len3 = len1+len2;
        
        int[] num3 = new int[len3];
        
        for(int i=len1-1; i>=0; i--){
            int advance = 0;
            int j;
            for(j=len2-1; j>=0; j--){
                int product = advance+num3[i+j+1]+Character.getNumericValue(num1.charAt(i))*
                Character.getNumericValue(num2.charAt(j));
                num3[i+j+1] = product%10;
                advance = product/10;
            }
            num3[i+j+1] = advance;
        }
        
        int index = 0;
        while(index<len3-1&&num3[index]==0){   //index<len3-1而不是len3
            index++;
        }
        StringBuilder s = new StringBuilder();
        for(; index<len3; index++){
            s.append(num3[index]);
        }
        return s.toString();
        
    }
}