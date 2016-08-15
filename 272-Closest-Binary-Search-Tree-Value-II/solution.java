/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> series = helper(root);
        List<Integer> ans = new ArrayList();
        if(series.get(0)>=target){
            for(int i=0; i<k; i++){
                ans.add(series.get(i));
            }
            return ans;
        }else if(series.get(series.size()-1)<=target){
            for(int i=series.size()-1; i>=series.size()-k; i--){
                ans.add(series.get(i));
            }
            return ans;
        }
        
        int start = 0;
        
        while(series.get(start)<target&&series.get(start+1)<target){
            start++;
        }
        int end = start+1;
        
        int index = 0;
        while(index<k){
            if(start>=0&&end<series.size()){
                if(series.get(start)+series.get(end)>target*2){
                    ans.add(series.get(start));
                    start--;
                }else{
                    ans.add(series.get(end));
                    end++;
                }
            }else if(start<0){
                ans.add(series.get(end));
                end++;
            }else if(end>=series.size()){
                ans.add(series.get(start));
                start--;
            }
            index++;
        }
        
        return ans;
    }
    
    private List<Integer> helper(TreeNode root){
        List<Integer> res = new ArrayList();
        if(root==null)  return res;
        
        List<Integer> left = helper(root.left);
        List<Integer> right = helper(root.right);
        
        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        
        return res;
    }
}