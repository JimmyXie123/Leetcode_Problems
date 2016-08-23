public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int inDegree[] = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            inDegree[prerequisites[i][0]]++;
        }
        
        int[] res = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new LinkedList();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i]==0)  queue.offer(i);
        }
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            res[index++] = curr;
            for(int i=0; i<prerequisites.length; i++){
                if(prerequisites[i][1]==curr){
                    inDegree[prerequisites[i][0]]--;
                    if(inDegree[prerequisites[i][0]]==0)  queue.offer(prerequisites[i][0]);
                }
            }
        }
        
        for(int i=0; i<numCourses; i++){
            if(inDegree[i]!=0)  return new int[0];
        }
        
        return res;
        
    }
}