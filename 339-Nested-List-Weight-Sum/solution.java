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
    public int depthSum(List<NestedInteger> nestedList) {
        for(NestedInteger element:nestedList){
            helper(element, 1);
        }
        return sum;
    }
    
    private void helper(NestedInteger element, int level){
        if(element.isInteger()){
            sum += element.getInteger()*level;
        }else{
            for(NestedInteger sub: element.getList()){
                helper(sub, level+1);
            }
        }
    }
}