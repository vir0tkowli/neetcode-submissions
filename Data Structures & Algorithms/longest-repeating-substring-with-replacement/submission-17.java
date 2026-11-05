class Solution {
    public int characterReplacement(String s, int k) {
        if (s.isEmpty()) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int maxLength = 0;

        HashMap<Character, Integer> frqMap = new HashMap<>();
        frqMap.put(s.charAt(0), 1);

        while (end < s.length()) {
            // Record valid windows and keep expanding.
            while (end < s.length() && end - start + 1 - highestFrequency(frqMap) <= k) {
                int windowSize = end - start + 1;

                maxLength = Math.max(maxLength, windowSize);
                end++;

                if (end < s.length()) {
                    char incoming = s.charAt(end);
                    frqMap.put(incoming, frqMap.getOrDefault(incoming, 0) + 1);
                }
            }

            // if (end == s.length()) {
            //     break;
            // }   

            // The window is invalid: remove its leftmost character.
            char outgoing = s.charAt(start);
            frqMap.put(outgoing, frqMap.get(outgoing) - 1);
            start++;
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