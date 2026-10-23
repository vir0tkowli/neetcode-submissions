class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("", 0, 0, n);
        return result;
    }

    private void dfs(String s, int open, int close, int n) {
        if(open == n && close == n) {
            result.add(s);
            return;
        }

        if(open < n) {
            s = s + '(';
            dfs(s, open + 1, close, n);
            s = s.substring(0, s.length() - 1);
        }

        if(close < open) {
            s = s + ')';
            dfs(s, open, close + 1, n);
            s = s.substring(0, s.length() - 1);
        }
    }
}
