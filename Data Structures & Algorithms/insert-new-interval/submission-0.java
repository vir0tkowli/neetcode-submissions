class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //int n = intervals.length;
        int[][] result = new int[intervals.length + 1][2];
        int resIdx = 0;
        int i = 0;
        // 1. Add intervals completely before the new interval.
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result[resIdx] = intervals[i];
            resIdx++; i++;
        }

        int start = newInterval[0];
        int end = newInterval[1];

        // 2. Merge all overlapping intervals.
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        // 3. Add the merged interval exactly once.
        result[resIdx] = new int[]{start, end};
        resIdx++;
        
        // 4. Add all remaining intervals.
        while (i < intervals.length) {
            result[resIdx] = intervals[i];
            resIdx++; i++;
        }


         // Remove unused array entries.
        return Arrays.copyOf(result, resIdx);
    }
}
