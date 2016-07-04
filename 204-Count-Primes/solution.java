public class Solution {
    private boolean isPrime(int w){
        if(w==2){
            return true;
        }
        for(int i=2; i<Math.sqrt(w)+1; i++){
            if(w%i==0){
                return false;
            }
        }
        return true;
    }
    public int countPrimes(int n) {
        HashSet<Integer> set = new HashSet();
        for(int i=2; i<n; i++){
            if(isPrime(i)){
                set.add(i);
            }
        }
        return set.size();
    }
}