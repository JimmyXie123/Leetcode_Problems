public class Solution {
    private boolean isZero(int A, int B, int C, int D, int E, int F, int G, int H){
        if(Math.min(A,C)>Math.max(E, G)||Math.min(E, G)>Math.max(A, C)||Math.min(B, D)>Math.max(F, H)||Math.min(F, H)>Math.max(B, D)){
            return true;
        }else{
            return false;
        }
    }
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(isZero(A, B, C, D, E, F, G, H)){
            return (C-A)*(D-B)+(G-E)*(H-F);
        }
        
        int left_X = Math.max(Math.min(A, C), Math.min(E, G));
        int left_Y = Math.max(Math.min(B, D), Math.min(F, H));
        int right_X = Math.min(Math.max(A, C), Math.max(E, G));
        int right_Y = Math.min(Math.max(B, D), Math.max(F, H));
        
        return (C-A)*(D-B)+(G-E)*(H-F)-(right_X-left_X)*(right_Y-left_Y);
    }
}