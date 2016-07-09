public class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while(n>0){
            res = res.append((char)((n-1)%26+'A'));
            n = (n-1)/26;
        }
        String result = res.reverse().toString();
        return result;
    }
}