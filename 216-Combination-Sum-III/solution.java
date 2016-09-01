public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        if(k<=0||k>9||n>45||n<=0)  return res;
        helper(res, list, k, n, 1);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int count, int target, int pos){
        if(count==0){
            if(target==0)   res.add(new ArrayList(list));
            return;
        }
        
        if(target<=0)  return;
        
        for(int i=pos; i<=9; i++){
            list.add(i);
            helper(res, list, count-1, target-i, i+1);
            list.remove(list.size()-1);
        }
    }
}