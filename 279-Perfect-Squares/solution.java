//-------------同combination sum
public class Solution {
    int min = Integer.MAX_VALUE;
    public int numSquares(int n) {
        int num = 0;
        while(num*num<=n){
            num++;
        }
        num--;
        List<Integer> nums = new ArrayList();
        for(int i=1; i<=num; i++){
            nums.add(i*i);
        }
        
        helper(nums, 0, n, 0);
        return min;
    }
    
    private void helper(List<Integer> nums, int pos, int sum, int count){
        if(sum<0){
            return;
        }
        if(sum==0){
            if(count<min){
                min = count;
            }
        }
        
        for(int i= pos; i<nums.size(); i++){
            count++;
            helper(nums, i, sum-nums.get(i), count);
            count--;
        }
    }
}