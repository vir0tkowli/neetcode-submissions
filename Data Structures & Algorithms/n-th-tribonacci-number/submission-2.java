class Solution {
    public int tribonacci(int n) {
        
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        //memo[0] = 0; memo[1] = 1; memo[2] = 1;
        return dfs(n, memo);
    }

    private int dfs(int n, int[] memo) {
        if(n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        if(memo[n] != -1) {
            return memo[n];
        }

        memo[n] = dfs(n -1, memo) + dfs(n -2, memo) + dfs(n -3, memo);
        return memo[n];
    }
}