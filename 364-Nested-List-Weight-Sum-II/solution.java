/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    int sum = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList==null){
            return 0;
        }
        sum(nestedList, getLevel(nestedList));
        return sum;
    }
    
    private int getLevel(List<NestedInteger> list){
        int res = 0;
        for(NestedInteger item:list){
            if(item.isInteger()){
                res = Math.max(1, res);
            }else{
                res = Math.max(getLevel(item.getList())+1, res);
            }
        }
        return res;
    }
    
    private void sum(List<NestedInteger> list, int level){
        for(NestedInteger item:list){
            if(item.isInteger()){
                sum += level*item.getInteger();
            }else{
                sum(item.getList(), level-1);
            }
        }
    }
}