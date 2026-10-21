class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        dfs(0, subset, nums);
        return result;
    }

    private void dfs(int index, List<Integer> subset, int[] nums) {
        if(index >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(index + 1, subset, nums);
        subset.remove(subset.size() -1);
        dfs(index + 1, subset, nums);
    }
}
