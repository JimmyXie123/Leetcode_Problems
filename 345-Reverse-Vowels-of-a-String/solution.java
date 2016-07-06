public class Solution {
    public String reverseVowels(String s) {
        if(s==null){
            return null;
        }
        HashSet<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int start = 0, end =s.length()-1;
        char ch[] = s.toCharArray();
        while(start<end){
            if(set.contains(ch[start])&&set.contains(ch[end])){
                char tmp = ch[start];
                ch[start] = ch[end];
                ch[end] = tmp;
                start++;
                end--;
            }else if(set.contains(ch[start])&&!set.contains(ch[end])){
                end--;
            }else if(!set.contains(ch[start])&&set.contains(ch[end])){
                start++;   
            }else{
                end--;
                start++;
            }
        }
        return new String(ch);
    }
}