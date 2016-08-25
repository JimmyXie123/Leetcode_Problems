public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList();
        remove(s, 0, 0, new char[]{'(', ')'}, res);
        return res;
    }
    
    private void remove(String str, int last_i, int last_j, char[] ch, List<String> res){
        for(int i=last_i, stack=0; i<str.length(); i++){
            if(str.charAt(i)==ch[0]) stack++;
            if(str.charAt(i)==ch[1]) stack--;
            if(stack>=0) continue;
            
            for(int j=last_j; j<=i; j++){
                if((j==last_j||str.charAt(j-1)!=ch[1])&&str.charAt(j)==ch[1]){
                    remove(str.substring(0, j)+str.substring(j+1, str.length()), i, j, ch, res);
                }
            }
            return;
        }
        
        String reverse = new StringBuilder(str).reverse().toString(); 
        if(ch[0]=='('){
            remove(reverse, 0, 0, new char[]{')', '('}, res);
        }else{
            res.add(reverse);
        }
    }    
    
}