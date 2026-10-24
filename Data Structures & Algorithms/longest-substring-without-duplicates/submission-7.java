class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int i = 0, j = i + 1;
        for (i = 0; i < s.length(); i++) {
            j = i + 1;
            set.add(s.charAt(i));
            while(j < s.length()) {
                if(set.contains(s.charAt(j))) {
                    break;
                } else {
                    set.add(s.charAt(j));
                    j++;
                }
            }
            max = Math.max(max, j-i);
            set.clear();
        }
        return max;
    }
}
