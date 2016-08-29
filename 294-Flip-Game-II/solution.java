public class Solution {
    public boolean canWin(String s) {
        int len = s.length();
        boolean[] state = new boolean[len];
        for(int i=0; i<len; i++){
            if(s.charAt(i)=='+')  state[i] = true;
        }
        
        return helper(state);
    }
    
    private boolean helper(boolean[] state){
        for(int i=0; i<state.length-1; i++){
            if(state[i]&&state[i+1]){
                state[i] = !state[i];
                state[i+1] = !state[i+1];
                if(!helper(state))  {
                    state[i] = !state[i];
                    state[i+1] = !state[i+1];
                    return true;
                }
                state[i] = !state[i];
                state[i+1] = !state[i+1];
            }
        }
        return false;
    }
}