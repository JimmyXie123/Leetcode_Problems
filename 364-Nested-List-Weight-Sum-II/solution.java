/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    int level = 0;
    int sum = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        for(NestedInteger n:nestedList) getDepth(n, 0);
        for(NestedInteger n:nestedList) dfs(n, level);
        return sum;
    }
    
    private void getDepth(NestedInteger element, int depth){
        if(element.isInteger()){
            level = Math.max(depth+1, level);
            return;
        }else{
            for(NestedInteger sub:element.getList()){
                getDepth(sub, depth+1);
            }
        }
    }
    
    private void dfs(NestedInteger element, int depth){
        if(element.isInteger()){
            sum += element.getInteger()*depth;
        }else{
            for(NestedInteger sub:element.getList()){
                dfs(sub, depth-1);
            }
        }
    }
}