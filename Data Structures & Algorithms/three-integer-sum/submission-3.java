class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int left = 0; left < nums.length; left++) {
            // *** CRITICAL to avoid duplicates
            if (left > 0 && nums[left] == nums[left - 1]) continue;

            int right = nums.length -1; 
            int mid = left +1;
            while(mid < right) {
                
                if(nums[mid] + nums[right] + nums[left] == 0) {
                    List<Integer> triplet = new ArrayList<>(List.of(nums[left], nums[mid], nums[right]));
                    right--; mid++;
                    res.add(triplet);
                    // *** CRITICAL to avoid duplicates
                    while (mid < right && nums[mid] == nums[mid - 1]) {
                        mid++;
                    }
                } else if (nums[mid] + nums[right] + nums[left] > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        return res;
    }
}
