public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update:updates){
            getArray(res, update[0], update[1], update[2]);
        }
        return res;
    }
    
    private void getArray(int[] res, int start, int end, int incre){
        while(start<=end){
            res[start++] += incre;
        }
    }
}