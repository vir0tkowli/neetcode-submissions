class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddLen = findNextPalindrome(s, i, i);
            int evenLen = findNextPalindrome(s, i, i + 1);

            int curLen = Math.max(oddLen, evenLen);
            if(curLen > maxLen) {
                start = i - (curLen - 1)/2;
                maxLen = curLen;
            }

        }
        return s.substring(start, start + maxLen);
    }

    private int findNextPalindrome(String subStr, int start, int end) {
        while(start >= 0 && end < subStr.length() && subStr.charAt(start) == subStr.charAt(end)) {
            start--;
            end++;
        }
        // IMPOSSIBLE to guess the -1
        // Valid palindrome is between left + 1 and right - 1.
        return end - start - 1;
    }
}
