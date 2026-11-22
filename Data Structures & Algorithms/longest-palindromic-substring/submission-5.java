class Solution {
    String maxLen = "";
    public String longestPalindrome(String s) {

        for(int i = 0; i < s.length(); i++) {
            findPalindrome(s, i, i);
            findPalindrome(s, i, i + 1);
        }
        return maxLen;
    }

    private void findPalindrome(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            if (maxLen.length() < end - start +1) {
                maxLen = s.substring(start, end +1);
            }
            start--;
            end++;
        }
    }
}
