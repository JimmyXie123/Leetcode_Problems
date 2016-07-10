public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        double a = Math.log10(n)/Math.log10(3);
        return a-Math.floor(a)==0;
    }
}