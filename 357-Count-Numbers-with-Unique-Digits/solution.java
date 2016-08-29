public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int res = 1;
        for(int i=1; i<=n; i++){
            res += count(i);
        }
        return res;
    }
    
    private int count(int digits){
        int res = 9;
        for(int i=1; i<digits; i++){
            res = res*(10-i);
        }
        return res;
    }
}