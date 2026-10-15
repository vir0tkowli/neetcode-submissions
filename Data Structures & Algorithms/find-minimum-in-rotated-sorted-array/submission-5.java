class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        int res = nums[0];
        while (start <= end) {
            if(nums[start] < nums[end]) {
                res = Math.min(res, nums[start]);
                break;
            }
            int midIdx = start + (end-start)/2;
            res = Math.min(res, nums[midIdx]);
            if(nums[midIdx] >= nums[start]) {
                start = midIdx +1;
            } else {
                end = midIdx -1;
            }
        }
        return res;
    }
}
