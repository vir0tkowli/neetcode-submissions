class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int curMin = 1;
        int curMax = 1;

        for (int n : nums) {
            result = Math.max(result, n);
            if(n == 0) {
                curMin = 1; curMax =1;
                continue;
            }

            // SOOPER critical because curMax is changed
            int temp = curMax * n;
            curMax = Math.max(n, Math.max(n * curMax, n * curMin));
            curMin = Math.min(n, Math.min(temp, n * curMin));

            result = Math.max(result, Math.max(curMin, curMax));
        }

        return result;
    }
}
