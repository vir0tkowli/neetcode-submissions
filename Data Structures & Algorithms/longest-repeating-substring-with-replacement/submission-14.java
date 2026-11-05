class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> frqMap = new HashMap<>();

        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            // Expand the window.
            char incoming = s.charAt(end);
            frqMap.put(incoming, frqMap.getOrDefault(incoming, 0) + 1);

            // Shrink until the window needs at most k replacements.
            while (end - start + 1 - highestFrequency(frqMap) > k) {
                char outgoing = s.charAt(start);
                frqMap.put(outgoing, frqMap.get(outgoing) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    private int highestFrequency(HashMap<Character, Integer> frqMap) {
        int highest = 0;

        for (int count : frqMap.values()) {
            highest = Math.max(highest, count);
        }

        return highest;
    }
}