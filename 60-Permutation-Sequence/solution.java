public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        boolean[] used = new boolean[n];
        int factor = 1;
        k= k-1;
        for(int i=1; i<n; i++){
            factor *= i;
        }
        
        for(int i=0; i<n; i++){
            int index = k/factor;
            k = k%factor;
            for(int j=0; j<n; j++){
                if(used[j]==false){
                    if(index==0){
                        used[j] = true;
                        res.append((char)('0'+j+1));
                        break;
                    }else{
                        index--;
                    }
                }
            }
            if(n>i+1){
                factor = factor/(n-i-1);
            }
        }
        return res.toString();
        
    }
}