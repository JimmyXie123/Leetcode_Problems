public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null){
            return 0;
        }
        int i=0;
        int length = prices.length;
        List<Integer> options = new ArrayList();
        while(i<length){
            while(i<length-1&&prices[i+1]<=prices[i]){
                i++;
            }
            int sum = 0;
            while(i<length-1&&prices[i+1]>prices[i]){
                sum += prices[i+1]-prices[i];
                i++;
            }
            options.add(sum);
            sum = 0;
        }
        
        int[] pair1;
        int[] pair2;
        for(int i=0; i<options.length(); i++){
            if(options.get(i)>pair1[0]){
                pair1[0] = options.get(i);
                pair1[1] = i;
             }
        }
        options.remove(pair1[1]);
        for(int i=0; i<options.length(); i++){
            if(options.get(i)>pair2[0]){
                pair2[0] = options.get(i);
                pair2[1] = i;
             }
        }
        return (pair1[0] + pair2[0]);
    }
}