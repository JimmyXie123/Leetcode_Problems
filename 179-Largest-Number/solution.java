public class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        StringBuilder res = new StringBuilder();   
        for(int i=0; i<strs.length; i++){
            res.append(strs[i]);
        }
        int index = 0;
        while(index<res.length()&&res.charAt(index)=='0'){
            index++;
        }
        if(index==nums.length){
            return "0";
        }
        return res.substring(index).toString();
    }
}