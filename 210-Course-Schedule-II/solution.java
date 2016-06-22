public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if(prerequisites==null||prerequisites.length==0){
            return result;
        }
        int m = prerequisites.length;
        
        if(prerequisites[0].length==0){
            return result;
        }
        int n = prerequisites.length;
        
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<m; i++){
            for(int j=0; j<n-1; j++){
                if(!map.containsKey(prerequisites[i][j])){
                    map.put(prerequisites[i][j], 1);
                }else{
                    map.put(prerequisites[i][j], map.get(prerequisites[i][j])+1);
                }
            }
        }
        
        int index = 0;
        Queue<Integer> queue = new LinkedList();
        for(int i=0; i<m; i++){
            if(!map.containsKey(prerequisites[i][n-1])){
                result[index++] = prerequisites[i][n-1];
                queue.offer(prerequisites[i][n-1]);
            }
        }
        
        while(!queue.isEmpty()){
            Integer number =  queue.poll();
            for(int i=0; i<m; i++){
                if(prerequisites[i][n-1]==number.intValue()){
                    for(int j=0; j<n-1; j++){
                        map.put(prerequisites[i][j], map.get(prerequisites[i][j])-1);
                        if(map.get(prerequisites[i][j])==0){
                            System.out.println(index);
                            result[index++] = prerequisites[i][j];
                            queue.offer(prerequisites[i][j]);
                        }
                    }
                }
            }
        }
        
        return result;
        
    }
}