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
        for(int j=0; j<options.length(); j++){
            if(options.get(j)>pair1[0]){
                pair1[0] = options.get(j);
                pair1[1] = j;
             }
        }
        options.remove(pair1[1]);
        for(int k=0; k<options.length(); k++){
            if(options.get(k)>pair2[0]){
                pair2[0] = options.get(k);
                pair2[1] = k;
             }
        }
        return (pair1[0] + pair2[0]);
    }
}