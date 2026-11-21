class Solution {
    public boolean checkValidString(String s) {
        int minOpenCount = 0;
        int maxOpenCount = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                minOpenCount++;
                maxOpenCount++;
            } else if(c == ')') {
                minOpenCount = Math.max(0, minOpenCount - 1);
                maxOpenCount--;
            } else {
                // could act as both closing and opening brackets
                minOpenCount = Math.max(0, minOpenCount - 1);
                maxOpenCount++;
            }

            if (maxOpenCount < 0) {
                return false; // Too many ')' in this prefix.
            }
        }
        return minOpenCount == 0;

    }
}
