public class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> map;
    java.util.Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList();
        map = new HashMap();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = map.containsKey(val);
        if(res){
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean res = map.containsKey(val);
        if(!res){
            return res;
        }else{
            int index = map.get(val);
            if(index<nums.size()-1){
                int lastone = nums.get(nums.size()-1);
                nums.set(index, lastone);
                map.put(lastone, index);
            }
            map.remove(val);
            nums.remove(nums.size()-1);
        }
        return res;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */