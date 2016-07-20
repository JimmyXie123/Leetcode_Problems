public class Solution {
    public int singleNumber(int[] nums) {
        int A[] = new int[32];
        for(int i=0; i<32; i++){
            for(int num:nums){
                A[i] += (num>>i)&1;
            }
            A[i] = A[i]%3;
        }
        int result = 0;
        for(int i=0; i<32; i++){
            result |= (A[i]<<i);
        }
        return result;
    }
}