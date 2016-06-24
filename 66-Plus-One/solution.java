public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null){
            return new int[]{1};
        }
        int i=digits.length-1;
        int advance = 0;
        while(i>=0){
            digits[i] = digits[i]+1+advance;
            if(digits[i]<10){
                return digits;
            }else{
                digits[i] -= 10;
                advance = 1;
                if(i==0){
                    int[] result = new int[digits.length+1];
                    result[0] = 1;
                    for(int i=0; i<digits.length; i++){
                        result[i+1] = digits[i];
                    }
                    return result;
                }
                i--;
            }
        }
        
        return digits;
    }
}