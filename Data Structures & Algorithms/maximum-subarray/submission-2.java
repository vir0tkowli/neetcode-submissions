class Solution {
    public int maxSubArray(int[] nums) {
        int[] memo = new int[nums.length];
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }

        memo[0]=nums[0];
        int maxSum = nums[0];

        for(int i=1; i< nums.length; i++) {
            memo[i] = Math.max(memo[i-1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, memo[i]);
        }

        return maxSum;
    }
}
