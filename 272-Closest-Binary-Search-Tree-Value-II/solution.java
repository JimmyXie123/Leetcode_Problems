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
        Stack<TreeNode> pred = initializePredecessor(root, target);
        Stack<TreeNode> suc = initializeSuccessor(root, target);
        List<Integer> list = new ArrayList();
        while(k>0){
            if(!pred.isEmpty()&&!suc.isEmpty()){
                if(pred.peek().val==suc.peek().val){
                    list.add(getPredecessor(pred));
                    getSuccessor(suc);
                }else if(target-pred.peek().val>suc.peek().val-target){
                    list.add(getSuccessor(suc));
                }else{
                    list.add(getPredecessor(pred));
                }
            }else if(!pred.isEmpty()){
                list.add(getPredecessor(pred));
            }else if(!suc.isEmpty()){
                list.add(getSuccessor(suc));
            }
            k--;
        }
        
        return list;
    }
    
    private Stack<TreeNode> initializePredecessor(TreeNode root, double target){
        Stack<TreeNode> pred = new Stack();
        while(root!=null){
            if(root.val==target){
                pred.push(root);
                break;
            }
            if(root.val>target){
                root = root.left;
            }else{
                pred.push(root);
                root = root.right;
            }
        }
        return pred;
    }
    
    private Stack<TreeNode> initializeSuccessor(TreeNode root, double target){
        Stack<TreeNode> suc = new Stack();
        while(root!=null){
            if(root.val==target) {
                suc.push(root);
                break;
            }
            if(root.val>target){
                suc.push(root);
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return suc;
    }
    
    private int getPredecessor(Stack<TreeNode> pred){
        TreeNode tmp = pred.pop();
        int res = tmp.val;
        tmp = tmp.left;
        while(tmp!=null){
            pred.push(tmp);
            tmp = tmp.right;
        }
        return res;
    }
    
    private int getSuccessor(Stack<TreeNode> suc){
        TreeNode tmp = suc.pop();
        int res = tmp.val;
        tmp = tmp.right;
        while(tmp!=null){
            suc.push(tmp);
            tmp = tmp.left;
        }
        return res;
    }
}