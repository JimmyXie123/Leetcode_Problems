/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList();
        if(intervals==null||intervals.size()==0){
            return res;
        }
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a1, Interval a2){
                return a1.start-a2.start;   
            }
        });
        Interval last = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval curt = intervals.get(i);
            if(curt.start<=last.end){
                last.end = Math.max(last.end, curt.end);
            }else{
                res.add(last);
                last = curt;
            }
        }
        
        res.add(last);  //--------不能少啊-------------
        return res;
    }
}