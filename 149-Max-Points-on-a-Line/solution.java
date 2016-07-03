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
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for(int i= 0; i<points.length; i++){
            map.clear();
            int dup = 0;
            
            for(int j=i+1; j<points.length; j++){
                if(points[j].y==points[i].y&&points[j].x==points[i].x){
                    dup++;
                    continue;
                }
                int key = (points[j].x-points[i].x==0)?Integer.MAX_VALUE:(points[j].y-points[i].y)/(points[j].x-points[i].x);
                if(map.contiansKey(key)){
                    map.put(key, map.get(key)+1);
                }else{
                    map.put(key, 2);
                }
            }
            
            int temp = 0;
            for(int ele:map.values()){
                temp += ele;
            }
            if(temp+dup>max){
                max = temp+dup;
            }
        }
        
        return max;
        
    }
}