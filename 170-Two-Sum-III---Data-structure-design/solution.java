public class TwoSum {
    HashMap<Integer, Integer> map = new HashMap();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(!map.containsKey(number)){
	        map.put(number, 1);
	    }else{
	        map.put(number, map.get(number)+1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(int ele:map.keySet()){
	        if(map.containsKey(value-ele)){
	            if(value-ele!=ele){
	                return true;
	            }else if(map.get(ele)>1){
	                return true;
	            }
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);