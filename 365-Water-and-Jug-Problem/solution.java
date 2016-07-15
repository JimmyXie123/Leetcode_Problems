public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        //----------------排除异常情况-----------------------
        if(x+y<z){
            return false;      
        }
        if(x==z||y==z){
            return true;
        }
        return z%GCD(x, y)==0;
    }
    
    private int GCD(int a, int b){
        while(b!=0){
            int tmp = b;
            b=a%b;
            a=tmp;
        }
        return a;
    }
}