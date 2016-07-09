public class Solution {
    public boolean isReflected(int[][] points) {
        HashSet<String> set = new HashSet();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int[] p:points){
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            set.add(p[0]+"+"+p[1]);
        }
        int sum = max+min;
        for(int[] p:points){
            if(!set.contains((sum-p[0])+"+"+p[1])){
                return false;
            }    
        }
        return true;
        
    }
}