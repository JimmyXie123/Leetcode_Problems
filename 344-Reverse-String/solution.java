public class Solution {
    public String reverseString(String s) {
        if(s==null){
            return null;
        }
        int start = 0, end = s.length()-1;
        char ch[] = s.toCharArray();
        while(start<end){
            char tmp = ch[start];
            ch[start] = ch[end];
            ch[end] = tmp;
            start++;
            end--;
        }
        return new String(ch);
    }
}