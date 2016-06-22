public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList();
        remove(s, ans, 0, 0, new char[]{"(", ")"});
        return ans;
    }
    
    private void remove(String s, List<String> ans, int last_i, int last_j, char[] par){
        for(int i=last_i, stack=0; i<s.length(); i++){
            if(s.charAt(i)==par[0]) stack++;
            if(s.charAt(i)==par[1]) stack--;
            if(stack>=0) continue;
            for(int j=last_j; j<=i; j++){
                if((j==last_j||s.charAtCj-1)!=par[1])&&(s.charAt(j)==par[1])){
                    remove(s.substring(0, j)+s.substring(j+1, s.length), ans, i, j, par);
                }
            }
        }
        
        String reverse = new StringBuilder(s).reverse().toString();
        remove(reverse, ans, 0, 0, new char[]{")", "("});
        ans.add(reverse);
    }
}