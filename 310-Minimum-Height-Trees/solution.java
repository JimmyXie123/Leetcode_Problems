public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        HashMap<Integer, Node> graph = new HashMap();
        for(int i=0; i<n; i++){
            graph.put(i, new Node(i));
        }
        
        for(int[] e:edges){
            graph.get(e[0]).neighbors.add(graph.get(e[1]));
            graph.get(e[1]).neighbors.add(graph.get(e[0]));
            graph.get(e[0]).degree++;
            graph.get(e[1]).degree++;
        }
        
        Queue<Node> queue = new LinkedList();
        for(int i=0; i<n; i++){
            if(graph.get(i).degree==1){
                queue.offer(graph.get(i));
            }
        }
        
        while(n>2){
            
            Node temp = queue.poll();
            n--;
            graph.remove(temp.label);
            for(Node side:temp.neighbors){
                side.neighbors.remove(temp);
                side.degree--;
                if(side.degree==1){
                    queue.offer(side);
                }
            }
        }
        
        List<Integer> result = new ArrayList();
        for(Integer i:graph.keySet()){
            result.add(i);
        }
        return result;
    }
    
}

class Node{
    int label;
    int degree;
    HashSet<Node> neighbors;
    public Node(int label){
        this.label = label;
        degree = 0;
        neigbors = new HashSet(); 
    }
}