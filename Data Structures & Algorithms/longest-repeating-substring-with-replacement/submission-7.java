class Solution {
    public int characterReplacement(String s, int k) {
    char[] map = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        if(s.length() == 1) {
            return 1;
        }
        int maxLength = Integer.MIN_VALUE;
        for (char c: map) {
            int attempt = k;
            int start = 0;
            int j = start;
            while(j < s.length()) {
                if(attempt >= 0) {
                    if (s.charAt(j) != c) {
                        attempt--;
                    }

                    if (attempt >= 0) {
                        maxLength = Math.max(maxLength, j - start + 1);
                    }
                    j++;
                } else {
                    // IMPOSSIBLE TO CODE this
                    // You’re missing restoring an attempt when a mismatched character leaves the window. Currently, once attempt becomes negative, it stays negative. Only start advances, so the loop never ends.
                    if (s.charAt(start) != c) {
                        attempt++;
                    }   
                    start++;
                }
            }
        }
        return maxLength;
    }
}
