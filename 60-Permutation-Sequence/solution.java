public class Solution {
    public String getPermutation(int n, int k) {
        String res = "";
        int factor = 1;
        boolean[] used = new boolean[n]; 
        for(int i=1; i<n; i++){
            factor *= i;
        }
        k=k-1;
        
        
        for(int i=0; i<n; i++){
            int index = k/factor;
            k = k%factor;
            for(int j=0; j<n; j++){
                if(!used[j]){
                    if(index==0){
                        used[j]=true;
                        res +=(char)('0'+j+1);
                        break;
                    }else{
                        index--;
                    }
                }
            }
            if(n>i+1)  factor = factor/(n-i-1);
        }
        
        return res;
        
        
    }
}