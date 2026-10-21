class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[left] <= nums[mid]) {
                // left is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    // go left half still
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // right is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    // go right half still
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
