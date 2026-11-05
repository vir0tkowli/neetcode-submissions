class Solution {
    int count = 0 ;
    public int climbStairs(int n) {
        count = 0;
        // dfsRecursive(0, n);
        // return count;

        int[] memo = new int[n+1];
        return dfs(0, n, memo);
    }

    private int dfs(int curSum, int n, int[] memo) {
        if(curSum > n) {
            return 0;
        }
        if (curSum == n) {
            return 1;
        }
        if (memo[curSum] != 0) {
            return memo[curSum]; // Already calculated.
        }
        int takeOneStep = dfs(curSum + 1, n, memo);
        int takeTwoSteps = dfs(curSum + 2, n, memo);

        memo[curSum] = takeOneStep + takeTwoSteps;
        return memo[curSum];
    }

    private void dfsRecursive(int curSum, int n) {
        if(curSum > n) {
            return;
        }
        if(curSum == n) {
            count++;
            return;
        }
        dfsRecursive(curSum + 1, n);        
        dfsRecursive(curSum + 2, n);     
    }
}
