public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int res = 1;
        for(int i=0; i<n; i++){
            res += count(i, 10);
        }
        return res;
    }
    
    private int count(int digits, int n){
        int sub = 9;
        for(int i=1; i<=digits; i++){
            sub *= (n-i);    
        }
        
        return sub;
    }
}