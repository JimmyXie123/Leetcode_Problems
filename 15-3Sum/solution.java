public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        HashMap<Integer, int[]> map = new HashMap();
        //List<Integer> path = new ArrayList();
        if(nums==null){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if (num[i] > 0) break;
            if(i>=1&&nums[i]==nums[i-1]){
                continue;
            }
            map.clear();
            for(int j=i+1; j<nums.length; j++){
                //System.out.println(j);
                if(map.containsKey(0-nums[j])){
                    int[] temp = map.get(-nums[j]);
                    List<Integer> path = new ArrayList();
                    path.add(temp[0]);
                    path.add(temp[1]);
                    path.add(nums[j]);
                    result.add(path);
                    while (j < (nums.length - 1) && num[j] == num[j + 1]) j++;
                }else{
                    int[] temp = new int[2];
                    temp[0] = nums[i];
                    temp[1] = nums[j];
                    map.put(nums[i]+nums[j], temp);
                }
                
            }
        }
        
        return result;
        
        
    }
/*  
public List<List<Integer>> threeSum(int[] num) {
    final int length = num.length;
    ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    HashMap<Integer, int[]> hashMap = new HashMap<Integer, int[]>();

    // if length is less than 3, return empty result set
    if (length < 3) return result;

    Arrays.sort(num);

    for (int i = 0; i < length - 2; i++) {
        if (num[i] > 0) break;
        hashMap.clear();

        if (i == 0 || num[i] > num[i - 1]) {
            for (int j = i + 1; j < length; j++) {
                if (hashMap.containsKey(num[j])) { // found target
                    ArrayList<Integer> elem = new ArrayList<Integer>(3);

                    elem.add(hashMap.get(num[j])[0]);
                    elem.add(hashMap.get(num[j])[1]);
                    elem.add(num[j]);

                    result.add(elem);

                    // remove duplicated elements
                    while (j < (length - 1) && num[j] == num[j + 1]) j++;
                } else {
                    int[] temp = new int[2];
                    temp[0] = num[i];
                    temp[1] = num[j];
                    hashMap.put(0 - (num[i] + num[j]), temp);
                }
            }
        }
    }
    return result;
}*/
}