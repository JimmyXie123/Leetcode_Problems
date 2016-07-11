public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0){
            return -1;
        }
        
        int[] res = new int[amount+1];
        res[0] = 0;
        
        for(int i=1; i<=amount; i++){        
            //for(int j=0; j<i; j++){      //---------内层循环不能循环amount啊，太大了---------------
            for(int coin:coins){
                if(i-coin<0||res[i-coin]==-1){
                    continue;
                }else{
                    if(res[i]==0){
                        res[i] = res[i-coin]+1;
                    }else{
                        res[i] = Math.min(res[i],res[i-coin]+1);
                    }
                }
            }
            if(res[i]==0){
                res[i] = -1;
            }
        }
        return res[amount];
    }
}