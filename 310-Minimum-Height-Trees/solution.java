public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, Node> graph = new HashMap();   //---------for adding neighbors-------------
        for(int i=0; i<n; i++){
            graph.put(i, new Node(i));
        }
        
        for(int[] edge:edges){
            graph.get(edge[0]).neighbors.add(graph.get(edge[1]));
            graph.get(edge[1]).neighbors.add(graph.get(edge[0]));
            graph.get(edge[0]).degree++;
            graph.get(edge[1]).degree++;
        }
        
        Queue<Node> queue = new LinkedList();
        for(int i=0; i<n; i++){
            if(graph.get(i).degree==1)  queue.offer(graph.get(i));
        }
        
        while(n>2){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node tmp = queue.poll();
                graph.remove(tmp.label);
                n--;
                for(Node side:tmp.neighbors){
                    graph.get(side.label).degree--;
                    graph.get(side.label).neighbors.remove(tmp);
                    if(graph.get(side.label).degree==1){
                        queue.offer(side);
                    }
                }
            }
        }
        
        List<Integer> res = new ArrayList();
        for(int i:graph.keySet()){
            res.add(i);
        }
        return res;
    }
}

class Node{
    int degree;
    int label;
    HashSet<Node> neighbors;
    public Node(int label){
        degree = 0;
        this.label = label;
        neighbors = new HashSet();
    }
}