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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList();
        int pos = 0;
        for(Interval i:intervals){
            if(i.end<newInterval.start){
                res.add(i);
                pos++;
            }else if(i.start>newInterval.end){
                res.add(i);
            }else{
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        res.add(pos, newInterval);
        return res;
    }
}