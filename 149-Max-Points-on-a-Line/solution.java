/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points==null||points.length==0){
            return 0;
        }
        int max = 1;
        HashMap<Double, Integer> map = new HashMap();
        for(int i= 0; i<points.length; i++){
            map.clear();
            int dup = 0;
            map.put((double)Integer.MIN_VALUE, 1);

            
            for(int j=i+1; j<points.length; j++){
                if(points[j].y==points[i].y&&points[j].x==points[i].x){
                    dup++;
                    continue;
                }
                double key = (points[j].x-points[i].x==0)?Integer.MAX_VALUE:0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x);
                if(map.containsKey(key)){
                    map.put(key, map.get(key)+1);
                }else{
                    map.put(key, 2);
                }
            }
            
            for(int ele:map.values()){
                if(ele+dup>max){
                    max = ele+dup;
                }
            }
        }
        
        return max;
        
    }
}