public class Solution {
    int low, max_len=0;
    public String longestPalindrome(String s) {
        if(s==null){
            return null;
        }
        
        if(s.length()<=1){
            return s;
        }
        
        int len = s.length();
        for(int i=0; i<len-1; i++){
            extend(s, i, i);
            extend(s, i, i+1);
        }
        return s.substring(low, low+max_len);
    }
    
    private void extend(String s, int start, int end){
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        if(max_len<end-start-1){
            max_len = end-start-1;
            low = start+1; 
        }
    }
}