class Solution {
    public boolean checkValidString(String s) {
        int minOpenCount = 0;
        int maxOpenCount = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') {
                minOpenCount++;
                maxOpenCount++;
            } else if(c == ')') {
                minOpenCount--;
                maxOpenCount--;
            } else {
                // could act as both closing and opening brackets
                minOpenCount--;
                maxOpenCount++;
            }

            if (maxOpenCount < 0) {
                return false; // Too many ')' in this prefix.
            }
            if (minOpenCount < 0) {
                minOpenCount = 0;
            }
        }
        return minOpenCount == 0;

    }
}
