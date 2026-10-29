class Solution {
    List<String> subsets;
    public List<String> letterCombinations(String digits) {
        String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "qprs", "tuv", "wxyz"
        };
        subsets = new ArrayList<>();
        if (digits.isEmpty()) {
            return subsets;
        }
        String str = "";
        //for(int i = 0; i < digits.toCharArray().length -1; i++) {
            dfs(digitToChar, str, digits, 0);
        //}
        return subsets;
    }

    private void dfs(String[] digitToChar, String str, String digits, int digitIdx) {
        if(str.length() == digits.length()) {
            subsets.add(str);
            return;
        }
        if(digitIdx >= digits.length() || str.length() > digits.length()) {
            return;
        }
        int index = Character.getNumericValue(digits.charAt(digitIdx));
        for(char c : digitToChar[index].toCharArray()) {
            str += c;
            dfs(digitToChar, str, digits, digitIdx + 1);
            str = str.substring(0, str.length() - 1);

        }
    }
}
