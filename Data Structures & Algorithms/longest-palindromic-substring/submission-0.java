class Solution {
    public String longestPalindrome(String s) {
        Set<String> result = new HashSet();

        for (int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                String subStr = s.substring(i, j + 1);
                if(isPalindrome(subStr)) {
                    result.add(subStr);
                }
            }
        }

        String maxLen = "";
        for(String r: result) {
            if(r.length() > maxLen.length()) {
                maxLen = r;
            }
        }

        return maxLen;
    }

    private boolean isPalindrome(String subStr) {
        int start = 0;
        int end = subStr.length() -1 ;
        while(start <= end) {
            if(subStr.charAt(start) != subStr.charAt(end)) {
                return false;
            }
            start++; end--;
        }

        return true;
    }
}
