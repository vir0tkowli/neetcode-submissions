class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] memo = new boolean[n];

        memo[n -1] = true;

        for(int i = n -2; i >= 0; i--) {

            int end = Math.min(n, i + nums[i] + 1);

            for(int j = i + 1; j < end; j++) {
                if(memo[j]) {
                    memo[i] = true; // JUST like a WOW
                    break;
                }
            }
        }

        return memo[0];
    }
}
