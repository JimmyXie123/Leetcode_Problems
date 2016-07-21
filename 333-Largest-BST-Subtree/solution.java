/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class returnType{
    boolean BST;
    int num;
    int min; 
    int max;
    public returnType(boolean BST, int num, int min, int max){
        this.BST = BST;
        this.num = num;
        this.min = min;
        this.max = max;
    }
}  

public class Solution {
    int count=0;
    public int largestBSTSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }
        returnType tmp = helper(root);
        return count;
    }
    
    private returnType helper(TreeNode node){
        if(node.left==null&&node.right==null){
            count = Math.max(count, 1);
            return new returnType(true, 1, node.val, node.val);
        }else if(node.left!=null&&node.right==null){
            returnType left = helper(node.left);
            if(left.max<node.val&&left.BST){
                count = Math.max(left.num+1, count);
                return new returnType(true, left.num+1, left.min, node.val); 
            }else{
                return new returnType(false, left.num, left.min, node.val);
            }
        }else if(node.left==null&&node.right!=null){
            returnType right = helper(node.right);
            if(right.min>node.val&&right.BST){
                count = Math.max(right.num+1, count);
                return new returnType(true, right.num+1, node.val, right.max); 
            }else{
                return new returnType(false, right.num, node.val, right.max);
            }
        }else{
            returnType left = helper(node.left);
            returnType right = helper(node.right);
            if(left.max<node.val&&left.BST&&right.BST&&right.min>node.val){
                count = Math.max(left.num+right.num+1, count);
                return new returnType(true, left.num+right.num+1, left.min, right.max); 
            }else{
                return new returnType(false, left.num+right.num, left.min, right.max);
            }
        }
    }
}

