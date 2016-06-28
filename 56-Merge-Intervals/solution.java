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
        int fast = 0;
        int size = intervals.size();
        i=0;
        while(i<size){
            Interval temp = new Interval();
            temp.start = intervals.get(i).start;
            while(fast<size-1&&intervals.get(fast).end>intervals.get(fast+1).start){
                fast++;
            }
            temp.end = intervals.get(fast).end;
            res.add(temp);
            fast++;
            i=fast;
        }
            
        return res;
    }
}