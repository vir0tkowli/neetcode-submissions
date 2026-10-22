class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> subset = new ArrayList<>();
        dfs(candidates, 0, subset, target);
        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, int index, List<Integer> subset, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if(target < 0 || index >= nums.length) {
            return;
        }

        for(int j = index; j < nums.length; j++) {

            if (j > index && nums[j] == nums[j - 1]) {
                continue;
            }
            if (nums[j] > target) {
                break;
            }
            if(target - nums[j] < 0) {
                return;
            }
        

            subset.add(nums[j]);
            dfs(nums, j + 1, subset, target - nums[j]);
            subset.remove(subset.size() -1);
            //dfs(nums, j + 1, subset, target);
        }
    }
}
