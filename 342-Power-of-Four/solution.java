public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<=0){
            return false;
        }
        
        double res = Math.log10(num)/Math.log10(4);
        return res-Math.floor(res)==0;
    }
}