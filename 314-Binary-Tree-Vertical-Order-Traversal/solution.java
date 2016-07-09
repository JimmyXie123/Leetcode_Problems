/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Pair{
    int depth;
    TreeNode node;
    public Pair(int depth, TreeNode node){
        this.depth = depth;
        this.node = node;
    }
}

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root==null){
            return res;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap();
        Queue<Pair> queue = new LinkedList();
        
        queue.offer(new Pair(0, root));   //------要考虑root是空的情况啊---------
        //int level = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Pair tmp = queue.poll();
                if(!map.containsKey(tmp.depth)){
                    map.put(tmp.depth, new ArrayList());
                }
                map.get(tmp.depth).add(tmp.node.val);
                
                if(tmp.node.left!=null){
                    queue.offer(new Pair(tmp.depth-1, tmp.node.left));
                }
                if(tmp.node.right!=null){
                    queue.offer(new Pair(tmp.depth+1, tmp.node.right));
                }
            }
            //level++;
        }
        for(int key:map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}