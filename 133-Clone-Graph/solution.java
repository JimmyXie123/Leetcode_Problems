/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> result = new HashMap();
        for(UndirectedGraphNode n:nodes){
            result.put(n, new UndirectedGraphNode(n.label));
        }
        
        for(UndirectedGraphNode n:nodes){
            for(UndirectedGraphNode w:n.neighbors){
                UndirectedGraphNode temp = result.get(w);
                result.get(n).neighbors.add(temp);
            }
        }
        
        return result.get(node);
    }
    
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        ArrayList<UndirectedGraphNode> nodes = new ArrayList();
        HashSet<UndirectedGraphNode> set = new HashSet();
        if(node==null){
            return nodes;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList();
        queue.offer(node);
        set.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode temp = queue.poll();
            //if(!set.contains(temp)){
            //set.add(temp);
            nodes.add(temp);
            //}
            for(UndirectedGraphNode n:temp.neighbors){
                if(!set.contains(n)){
                    queue.offer(n);
                    set.add(n);
                }
            }
        }
        return nodes;
    }
}