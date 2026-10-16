class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frqMap = new HashMap<>();
        for (Character c: tasks) {
            frqMap.put(c, frqMap.getOrDefault(c, 0) + 1);
        }

        if (frqMap.isEmpty()) {
            return 0;
        }

        int maxOccuringTaskFreq = 0;
        int numOfMaxOccuringTasks = 0;

        for (int frequency : frqMap.values()) {
            if (frequency > maxOccuringTaskFreq) {
                maxOccuringTaskFreq = frequency;
                numOfMaxOccuringTasks = 1;
            } else if (frequency == maxOccuringTaskFreq) {
                numOfMaxOccuringTasks++;
            }
        }
        // maxOccuringTaskFreq - 1 is the number of gaps between occurrences of the most frequent task. If A appears 3 times:There are 2 gaps, maxFrequency - 1 = 3 - 1 = 2
        // n counts only the intervals between identical tasks. n + 1 also includes the task itself.
        return Math.max(tasks.length, (n + 1) * (maxOccuringTaskFreq -1) + numOfMaxOccuringTasks);
    }
}
