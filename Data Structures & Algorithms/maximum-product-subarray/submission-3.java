class Solution {
    public int maxProduct(int[] nums) {
        int[] minMemo = new int[nums.length];
        int[] maxMemo = new int[nums.length];
        minMemo[0] = nums[0];
        maxMemo[0] = nums[0];
        int maxProd = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int extendMax = nums[i] * maxMemo[i - 1];
            int extendMin = nums[i] * minMemo[i - 1];

            maxMemo[i] = Math.max(nums[i], Math.max(extendMax, extendMin));
            minMemo[i] = Math.min(nums[i], Math.min(extendMax, extendMin));

            maxProd = Math.max(maxProd, maxMemo[i]);

        }

        return maxProd;
    }
}
