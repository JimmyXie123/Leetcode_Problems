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
        Stack<TreeNode> pre = new Stack();
        Stack<TreeNode> suc = new Stack();
        initializePredecessor(pre, root, target);
        initializeSuccessor(suc, root, target);
        
        List<Integer> res = new ArrayList();
        
        if(!pre.isEmpty()&&!suc.isEmpty()&&pre.peek().val==suc.peek().val){
            getPredecessor(pre);              //-----if root.val ==target--------------
        }
        
        while(k>0){
            if(!pre.isEmpty()&&!suc.isEmpty()){
                int high = suc.peek().val;    //--------peek not pop--------------- 
                int low = pre.peek().val;     //--------peek not pop------------
                if(Math.abs(high-target)>Math.abs(target-low)){
                    res.add(getPredecessor(pre));
                }else{
                    res.add(getSuccessor(suc));
                }
            }else if(!suc.isEmpty()){
                res.add(getSuccessor(suc));
            }else if(!pre.isEmpty()){
                res.add(getPredecessor(pre));
            }
            k--;
        }
        return res;
    }
    
    private void initializePredecessor(Stack<TreeNode> stack, TreeNode node, double target){
        while(node!=null){
            if(node.val==target){
                stack.push(node);
                break;
            }else if(node.val<target){
                stack.push(node);
                node = node.right;
            }else{
                node = node.left;
            }
        }
    }
    
    private void initializeSuccessor(Stack<TreeNode> stack, TreeNode node, double target){
        while(node!=null){
            if(node.val==target){
                stack.push(node);
                break;
            }else if(node.val>target){
                stack.push(node);
                node = node.left;
            }else{
                node = node.right;
            }
        }
    }
    
    private int getPredecessor(Stack<TreeNode> stack){
        TreeNode curr = stack.pop();
        int res = curr.val;
        curr = curr.left;
        while(curr!=null){
            stack.push(curr);
            curr = curr.right;
        }
        return res;
    }
    
    private int getSuccessor(Stack<TreeNode> stack){
        TreeNode curr = stack.pop();
        int res = curr.val;
        curr = curr.right;
        while(curr!=null){
            stack.push(curr);
            curr = curr.left;
        }
        return res;
    }
}