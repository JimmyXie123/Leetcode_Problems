public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] inDegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            result[i] = i;
        }
        
        if(prerequisites==null||prerequisites.length==0){
            return result;
        }
        int m = prerequisites.length;
        
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<m; i++){
                inDegree[prerequisites[i][0]]++;
        }
        
        int index = 0;
        Queue<Integer> queue = new LinkedList();
        for(int i=0; i<numCourses; i++){
            if( inDegree[i]==0 ){
                result[index++] = i;
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            Integer number =  queue.poll();
            for(int i=0; i<m; i++){
                if(prerequisites[i][1]==number.intValue()){
                    inDegree[prerequisites[i][0]]--;
                    if(inDegree[prerequisites[i][0]]==0){
                        result[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        
        for(int i=0; i<numCourses; i++){
            if(inDegree[i]!=0){
                return new int[0];
            }
        }
        return result;
        
    }
}