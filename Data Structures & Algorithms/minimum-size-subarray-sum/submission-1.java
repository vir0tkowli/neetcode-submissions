class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0; int j = 0;
        int minLength = Integer.MAX_VALUE;
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] >= target ? 1 : 0;
        }
        int currentSum = 0;
        while(j < nums.length || currentSum >= target) {
            if (currentSum >= target) {
                minLength = Math.min(minLength, j - i);
                currentSum -= nums[i];
                i++;
            } else {
                currentSum += nums[j];
                j++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}