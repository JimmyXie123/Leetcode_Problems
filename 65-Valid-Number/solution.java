public class Solution {
    public boolean isNumber(String s) {
        int len = s.length();
        int left = 0, right = len-1;
        while(left<len&&Character.isSpace(s.charAt(left))) left++;
        if(left==len) return false;
        while(Character.isSpace(s.charAt(right))) right--;
        while(left<len&&(s.charAt(left)=='+'||s.charAt(left)=='-')){
            left++;
        }
        boolean num = false;
        boolean exp = false;
        boolean dot = false;
        for(int i=left; i<=right; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = true;
            }else if(ch=='.'){
                if(exp||dot) return false;
                dot = true;
            }else if(ch=='e'){
                if(exp||num==false) return false;
                num = false;
                exp = true;
            }else if(ch=='+'||ch=='-'){
                if(s.charAt(i-1)!='e') return false;
            }else{
                return false;
            }
        }
        return num;
    }
}