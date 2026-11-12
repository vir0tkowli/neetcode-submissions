/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt((Interval i) -> i.start));
        for(int i = 1 ; i < intervals.size(); i++) {
            Interval curInt = intervals.get(i);
            Interval pastInt = intervals.get(i-1);
            if(pastInt.end > curInt.start) {
                return false;
            }
        }
        return true;
    }
}
