class Solution {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> set = new HashSet<>();
       int maxLength = 0;
       for (int i =0; i < s.length(); i++) {
        int j = i;
        while (j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            } else {
                break;
            }
        }
        set.clear();
        maxLength = Math.max(maxLength, j -i);
       }
       return maxLength;
    }
}
