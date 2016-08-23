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
        if(node==null)  return null;
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap();
        for(UndirectedGraphNode n:nodes){
            map.put(n, new UndirectedGraphNode(n.label));
        }
        
        for(UndirectedGraphNode n:nodes){
            for(UndirectedGraphNode neighbor:n.neighbors){
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    
    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        Queue<UndirectedGraphNode> queue = new LinkedList();
        ArrayList<UndirectedGraphNode> nodes = new ArrayList();
        HashSet<UndirectedGraphNode> set = new HashSet();
        
        queue.offer(node);
        set.add(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode curr = queue.poll();
            nodes.add(curr);
            for(UndirectedGraphNode n:curr.neighbors){
                if(set.contains(n)){
                    continue;
                }
                queue.offer(n);
                set.add(n);
            }
        }
        return nodes;
    }
}