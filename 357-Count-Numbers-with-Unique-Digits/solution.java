public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        long max = (long)Math.pow(10, n);
        boolean[] used = new boolean[10];
        if(n==0)    return 1;
        
        
        int res = 1;
        for(int i=1; i<10; i++){
            used[i] = true;
            res += helper(i, max, used);
            used[i] = false;
        }
        return res;
    }
    
    private int helper(long prev, long max, boolean[] used){
        int count = 0;
        if(prev<max){
            count++;
        }else{
            return count;
        }
        
        for(int i=0; i<10; i++){
            if(!used[i]){
                used[i] = true;
                long curr = prev*10+i;
                count += helper(curr, max, used);
                used[i] = false;
            }
        }
        return count;
    }
}