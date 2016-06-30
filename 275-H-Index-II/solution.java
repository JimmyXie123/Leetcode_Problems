public class Solution {
    public int hIndex(int[] citations) {
        
        if(citations==null||citations.length==0){
            return 0;
        }
        int len = citations.length;
        int start = 0, end = len-1;
        
        while(start+1<end){
            int mid = start+(end-start)/2;
            if(citations[mid]==len-mid){   //-----------这里一定是citations的长度，而不是变化的end--------
                return len-mid; 
            }else if(citations[mid]>len-mid){
                end = mid;                 //-----------find the first one--------------
            }else{
                start = mid;
            }
        }
        
        if(citations[start]>=len-start){
            return len-start;
        }
        if(citations[end]>=len-end){
            return len-end;
        }
        return 0;
    }
}