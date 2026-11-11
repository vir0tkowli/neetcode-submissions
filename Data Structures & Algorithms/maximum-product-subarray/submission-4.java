class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int prefix = 0;
        int suffix = 0;

        for(int i = 0; i < nums.length; i++) {
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[nums.length - 1 - i] * (suffix == 0 ? 1 : suffix);

            result = Math.max(result, Math.max(prefix, suffix));
        
        }
        return result;
    }
}
