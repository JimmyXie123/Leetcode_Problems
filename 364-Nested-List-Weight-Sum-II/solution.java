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
        int level = 0;
        for(NestedInteger item:nestedList){
            level = Math.max(level, getLevel(item));
        }
        
        for(NestedInteger item:nestedList){
            sum(item, level);
        }
        return sum;
    }
    
    private int getLevel(NestedInteger item){
        if(item.isInteger()){
            return 1;
        }else{
            int res = 0;
            for(NestedInteger sub:item.getList()){
                res = Math.max(getLevel(sub), res);
            }
            return res+1;
        }
    }
    
    private void sum(NestedInteger item, int level){
        if(item.isInteger()){
            sum += level*item.getInteger();
        }else{
            for(NestedInteger num:item.getList()){
                sum(num, level-1);
            }
        }
    }
}