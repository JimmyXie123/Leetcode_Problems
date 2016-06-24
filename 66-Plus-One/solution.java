public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null){
            return new int[]{1};
        }
        int i=digits.length-1;
        int advance = 0;
        while(i>=0){
            if(i==digits.length-1){
                digits[i] = digits[i]+1;
            }else{
                digits[i] = digits[i]+advance;
            }
            System.out.println("i="+i+" digits[i]="+digits[i]);
            if(digits[i]<10){
                return digits;
            }else{
                digits[i] -= 10;
                advance = 1;
                if(i==0){
                    int[] result = new int[digits.length+1];
                    result[0] = 1;
                    for(int j=0; j<digits.length; j++){
                        result[j+1] = digits[j];
                    }
                    return result;
                }
                i--;
            }
        }
        
        return digits;
    }
}