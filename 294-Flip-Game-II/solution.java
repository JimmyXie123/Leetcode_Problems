public class Solution {
    public boolean canWin(String s) {
        boolean state[] = new boolean[s.length()];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='+'){
                state[i] = true;
            }
        }
        
        return helper(state);
        
    }
    
    private boolean helper(boolean[] state){
        for(int i=0; i<state.length-1; i++){
            if(state[i]&&state[i+1]){
                state[i] = false;
                state[i+1] = false;
                if(!helper(state)){
                    state[i] = true;
                    state[i+1] = true;
                    return true;
                }
                state[i] = true;
                state[i+1] = true;
            }
        }
        return false;
    }
}