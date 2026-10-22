class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, target);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> subset, int target) {
        int curSum = subset.stream().reduce(0, Integer::sum);
        if(index >= nums.length || curSum > target) {
            return;
        }
        if (curSum == target) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(nums, index, subset, target);
        subset.remove(subset.size()-1);
        dfs(nums, index+1, subset, target);
    }
}
