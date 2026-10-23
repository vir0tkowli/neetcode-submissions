class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        if(nums == null || nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }
        List<Integer> subsets = new ArrayList<>();
        dfs(0, nums, subsets);
        return new ArrayList<>(result);
    }

    private void dfs(int idx, int[] nums, List<Integer> subsets) {
        // Every path is a valid subset, including the empty path.

        // if(idx >= nums.length) {
            result.add(new ArrayList<>(subsets));
            // return;
        
        for(int j = idx; j < nums.length; j++) {
            if(j > idx && nums[j] == nums[j-1]) {
                continue;
            }

            subsets.add(nums[j]);
            dfs(j + 1, nums, subsets);

            subsets.remove(subsets.size() - 1);
            //dfs(idx + 1, nums, subsets);
        }
    }
}
