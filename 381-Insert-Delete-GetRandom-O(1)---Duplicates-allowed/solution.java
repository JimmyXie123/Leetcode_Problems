import java.util.Random;

public class RandomizedCollection {
    ArrayList<Integer> nums;
    HashMap<Integer, HashSet<Integer>> map;
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList();
        map = new HashMap();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = false;
        if(!map.containsKey(val)){
            res = true;
            map.put(val, new HashSet());
            map.get(val).add(nums.size());
            nums.add(val);
        }else{
            map.get(val).add(nums.size());
            nums.add(val);
        }
        return res;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean res = false;
        if(!map.containsKey(val)){
            return false;
        }else{
            int index = map.get(val).iterator().next();
            map.get(val).remove(index);
            if(index<nums.size()-1){
                map.get(nums.get(nums.size()-1)).add(index);
                map.get(nums.get(nums.size()-1)).remove(nums.size()-1);
            }
            nums.set(index, nums.get(nums.size()-1));
            nums.remove(nums.size()-1);
            if(map.get(val).size()==0)  map.remove(val);
            return true;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */