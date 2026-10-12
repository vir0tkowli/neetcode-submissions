class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i =0; int j =0; int maxLength = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                //maxLength = Math.max(maxLength, j - i);
                set.remove(s.charAt(i));
                // j++; 
                i++;
            }
        }
        return maxLength;
    }
}
