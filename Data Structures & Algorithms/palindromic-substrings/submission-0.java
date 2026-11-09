class Solution {
    public int countSubstrings(String s) {
        int start = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLenCount = findNextPalindrome(s, i, i);
            int evenLenCount = findNextPalindrome(s, i, i + 1);
            result += (oddLenCount + evenLenCount);
        }

        return result;
    }

    private int findNextPalindrome(String s, int start, int end) {
        int curCount = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            curCount++;
        }
        return curCount;
    }
}
