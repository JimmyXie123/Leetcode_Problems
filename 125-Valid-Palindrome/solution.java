public class Solution {
    private boolean isValid(char c){
        if(Character.isLetter(c)||Character.isDigit(c)){
            return true;
        }
        return false;
    }
    
    public boolean isPalindrome(String s) {
        if(s==null){
            return true;
        }
        int start=0, end=s.length()-1;
        char ch[] = s.toCharArray();
        while(start<end){
            if(isValid(ch[start])&&isValid(ch[end])){
                if(Character.toLowerCase(ch[start])!=Character.toLowerCase(ch[end])){
                    return false;
                }
                start++;
                end--;
            }else if(isValid(ch[start])&&!isValid(ch[end])){
                end--;
            }else if(!isValid(ch[start])&&isValid(ch[end])){
                start++;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
}