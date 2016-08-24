/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap(); 
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)  return null;
        UndirectedGraphNode curr = new UndirectedGraphNode(node.label);
        map.put(node, curr);
        for(UndirectedGraphNode neighbor:node.neighbors){
            if(!map.containsKey(neighbor))  curr.neighbors.add(cloneGraph(neighbor));
            else curr.neighbors.add(map.get(neighbor));
        }
        return curr;
    }
}