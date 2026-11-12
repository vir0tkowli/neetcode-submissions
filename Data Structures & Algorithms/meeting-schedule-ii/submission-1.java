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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt((Interval i) -> i.start));
        PriorityQueue<Interval> heap = new PriorityQueue<>(Comparator.comparingInt((Interval i) -> i.end));
        for(int i = 0; i < intervals.size(); i++) {
            Interval curInt = intervals.get(i);
            if(heap.isEmpty()) {
                heap.offer(curInt);
                continue;
            }
            if(heap.peek().end > curInt.start) {
                heap.offer(curInt);
            } else {
                heap.poll();
                heap.offer(curInt);
            }
        }

        return heap.size();
    }
}
