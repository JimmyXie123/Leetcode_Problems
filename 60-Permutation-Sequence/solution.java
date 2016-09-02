public class Solution {
    public String getPermutation(int n, int k) {
        String res = "";
        boolean[] used =new boolean[n];
        int factor = 1;
        for(int i=1; i<n; i++) {
            factor *= i;
        }
        k = k-1;
        
        for(int i=0; i<n; i++){
            int index = k/factor;
            k = k%factor;
            for(int j=0; j<n; j++){
                if(used[j]==false){
                    if(index==0){
                        used[j] = true;
                        res += (char)('1'+j);
                        break;
                    }else{
                        index--;
                    }
                }
            }
            if(n>i+1)   factor = factor/(n-i-1);
        }
        return res;
    }
}