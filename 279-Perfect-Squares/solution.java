public class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList();
        int[] dp = new int[n+1];
        for(int i=1; i*i<=n; i++){
            if(i*i==n)  return 1;
            queue.offer(i*i);
            dp[i*i] = 1;
        }
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i=1; i*i<=n-curr; i++){
                if(i*i==n-curr){
                    return dp[curr]+1;
                }else if(i*i<n-curr&&dp[i*i+curr]==0){
                    dp[i*i+curr] = dp[curr]+1;
                    queue.offer(i*i+curr);
                }else if(i*i+curr>n){
                    break;
                }
            }
        }
        
        return dp[n];
    }
}