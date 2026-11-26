class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) {
            return s.length();
        }
        int left = 0;
        int right = 1;
        int maxLen = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while(right < s.length()) {
            char incoming = s.charAt(right);

            if(set.contains(incoming)) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(incoming);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }
        }

        return maxLen;
    }
}
