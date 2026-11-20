class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int maxSum = nums[0];
        int runningSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            runningSum = Math.max(runningSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, runningSum);
        }

        return maxSum;
    }
}
