class Solution {
    public int rob(int[] nums) {
        int len = nums.length -1;
        int[] memo = new int[len + 1];
        memo[len] = nums[len];
        return dfs(0, nums, memo);
    }

    private int dfs(int idx, int[] nums, int[]memo) {
        if(idx >= nums.length) {
            return 0;
        }
        if(memo[idx] != 0) {
            return memo[idx];
        }
        memo[idx] = Math.max(dfs(idx+1, nums, memo), nums[idx] + dfs(idx+2, nums, memo));
        return memo[idx];
    }
}
