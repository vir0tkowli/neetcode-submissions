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

        return Math.max(tasks.length, (n + 1) * (maxOccuringTaskFreq -1) + numOfMaxOccuringTasks);
    }
}
