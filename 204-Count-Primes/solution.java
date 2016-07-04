public class Solution {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        int count = 0;
        boolean[] isPrime = new boolean[n];
        for(int i=2; i<n; i++){
            if(isPrime[i]==false){
                count++;
            }else{
                continue;
            }
            for(int j=2; j*i<n; j++){
                isPrime[i*j] = true;
            }
        }
        return count;
    }
}