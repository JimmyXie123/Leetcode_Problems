import java.lang.Integer;
public class Solution {
    public int myAtoi(String str) {
        if(str==null){
            return 0;
        }
        str = str.trim();
        if(str.length()==0){
            return 0;
        }
        int sign = 1;
        int index = 0;
        
        if(str.charAt(index)=='+'){
            index++;
        }else if(str.charAt(index)=='-'){
            index++;
            sign = -1;
        }
        
        long L = 0;
        for(; index<str.length(); index++){
            if(!Character.isDigit(str.charAt(index))){
                break;
            }
            L = L*10+(str.charAt(index)-'0');
            if(L>Integer.MAX_VALUE){
                break;
            }
        }
        if(L*sign>=Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(L*sign<=Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        
        return (int)L*sign;
        
    }
}