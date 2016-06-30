public class Solution {
    public int hIndex(int[] citations) {
        if (citations==null || citations.length==0) { return 0; }
        int len = citations.length;
        int left = 0, right = len-1;
        while (left < right-1) {
            int mid = left + (right-left)/2;
            if (citations[mid] >= len-mid) { right = mid; }  // we want to find the first one, go left
            else { left = mid; }
        }
        if (citations[left] >= len-left) { return len-left; }
        else if (citations[right] >= len-right) { return len-right; }
        return 0;
        /*
        if(citations==null||citations.length==0){
            return 0;
        }
        int start = 0, end = citations.length-1;
        
        while(start+1<end){
            int mid = start+(end-start)/2;
            if(citations[mid]>=end-mid+1){
                end = mid; 
            }else{
                start = mid;
            }
        }
        
        System.out.println("start="+start);
        System.out.println("end="+end);
        
        if(citations[start]>=citations.length-start){
            return citations.length-start;
        }
        if(citations[end]>=citations.length-end){
            return citations.length-end;
        }
        return 0;*/
    }
}