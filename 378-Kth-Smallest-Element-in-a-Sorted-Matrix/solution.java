class Node {
    int x;
    int y;
    int value;
    public Node(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length; 
        int n = matrix[0].length;
        PriorityQueue<Node> heap = new PriorityQueue(new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                return n1.value-n2.value;
            }
        });
        int count = 0;
        for(int i=0; i<m; i++){
            heap.offer(new Node(i, 0, matrix[i][0]));
        }
        
        Node res = null;
        while(count<k){
            res = heap.poll();
            count++;
            while(res.y==n-1&&count<k){
                res = heap.poll();
                count++;
            }
            if(count<k) heap.offer(new Node(res.x, res.y+1, matrix[res.x][res.y+1]));
        }
        return res.value;
    }
}