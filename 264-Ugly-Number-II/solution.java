public class Solution {
    public int nthUglyNumber(int n) {
        if(n==1){
            return 1;
        }
        PriorityQueue<Long> ugly = new PriorityQueue<Long>();
        HashSet<Long> set = new HashSet();
        Long[] prime = new Long[3];
        prime[0] = new Long[2];
        prime[1] = new Long[3];
        prime[2] = new Long[5];
        for(int i=0; i<3; i++){
            set.add(prime[i]);
            ugly.add(prime[i]);
        }
        
        Long number = new Long(0);
        for(int i=0; i<n-1; i++){
            number = ugly.poll();
            for(int j=0; j<3; j++){
                if(!set.contains(prime[j]*number)){
                    ugly.add(prime[j]*number);
                    set.add(prime[j]*number);
                }
            }
        }
        return number.intValue();
        
    }
}