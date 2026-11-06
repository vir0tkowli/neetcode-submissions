class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length -1 ;
        int[] memo = new int[len + 1];
        memo[len] = cost[len];
        return Math.min(dfs(cost, memo, 0), dfs(cost, memo, 1));
    }

    private int dfs(int[] cost, int[] memo, int curIdx) {
        if(curIdx >= cost.length) {
            return 0;
        }

        if(memo[curIdx] != 0) {
            return memo[curIdx];
        }

        memo[curIdx] = cost[curIdx] + Math.min(dfs(cost, memo, curIdx + 1), dfs(cost, memo, curIdx + 2));
        return memo[curIdx];
    }
}
