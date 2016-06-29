public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] times = new int[n+1];
        if(citations==null||citations.length==0){
            return 0;
        }
        for(int i:citations){
            if(i>=n){
                times[n]++;
            }else{
                times[citations[i]]++;   
            }
        }
        int sum = 0;
        i = n;
        while(i>=0){
            sum = sum+times[i];
            if(sum>=i){
                return i;
            }
        }
        return 0;
    }
}