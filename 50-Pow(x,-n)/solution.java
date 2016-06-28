public class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        if(n>0){
            for(int i=0; i<n; i++){
                res *= x;
            }
        }else{
            //System.out.println("123");
            for(int i=0; i<-n; i++){
                res = res/x;
            }
        }
        return res;
    }
}