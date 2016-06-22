public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null||prerequisites.length==0){
            return false;
        }
        int m = prerequisites.length;
        
        int[] inDegree = new int[numCourses];
        for(int i=0; i<m; i++){
            inDegree[prerequisites[i][0]]++;
        }
        
        
        Queue<Integer> queue = new LinkedList();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpth()){
            Integer number = queue.poll();
            for(int i=0; i<m; i++){
                if(prerequisites[i][1]==number.intValue()){
                    inDegree[prerequisites[i][0]]--;
                    if(inDegree[prerequisites[i][0]]==0){
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        
        for(int i=0; i<numCourses; i++){
            if(inDegree[i]!=0){
                return false;
            }
        }
        
        return true;
        
    }
}