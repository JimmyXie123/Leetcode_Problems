public class Solution {
    private int height(char[][] matrix, int i, int j){
        int height = 0;
        while(i<matrix.length&&matrix[i][j]!='0'){
            height++;
            i++;
        }
        return height;
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null){
            return 0;
        }
        int max = 0;
        for(int i=0; i<matrix.length; i++){
            Stack<Integer> stack = new Stack();
            for(int j=0; j<=matrix[i].length; j++){
                int curt = (j==matrix[i].length)?-1:height(matrix, i, j);
                System.out.println(curt);
                while(!stack.isEmpty()&&curt<=height(matrix, i, stack.peek())){
                    int h = height(matrix, i, stack.pop().intValue());
                    int w = (stack.isEmpty())?j:j-stack.peek()-1;
                    max = Math.max(max, w*h);
                }
                stack.push(j);
            }
        }
        return max;
    }
}