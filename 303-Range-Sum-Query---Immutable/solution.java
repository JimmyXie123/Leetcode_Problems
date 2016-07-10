public class NumArray {
    int subsum[]; 
    public NumArray(int[] nums) {
        subsum = new int[nums.length+1];
        subsum[0] = 0;
        for(int i=1; i<nums.length+1; i++){
            subsum[i] = subsum[i-1]+nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return subsum[j+1] - subsum[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);