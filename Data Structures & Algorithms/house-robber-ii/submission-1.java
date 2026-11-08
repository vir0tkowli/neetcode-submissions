class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
         if (len == 1) {
            return nums[0];
        }
        int[] memo = new int[len];
        Arrays.fill(memo, -1);

         // Consider houses 0 through n - 2.
        int excludeLast = dfs(0, nums, memo, len -1);
        Arrays.fill(memo, -1);
        int excludeFirst = dfs(1, nums, memo, len);
        return Math.max(excludeLast, excludeFirst);
    }

    private int dfs(int curIdx, int[] nums, int[] memo, int endIdx) {
        if(curIdx >= endIdx) {
            return 0;
        }
        if(memo[curIdx] != -1) {
            return memo[curIdx];
        }

        memo[curIdx] = Math.max(dfs(curIdx + 1, nums, memo, endIdx), nums[curIdx] + dfs(curIdx +2, nums, memo, endIdx));
        return memo[curIdx];
    }
}
