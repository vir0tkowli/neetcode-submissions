class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        dfs(subset, new boolean[nums.length], nums, 0);
        return new ArrayList<>(result);
    }

    private void dfs(List<Integer> subset, boolean[] visited, int[] nums, int idx) {
        if(subset.size() == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for(int j = 0; j < nums.length; j++) {
            if(j > 0 && nums[j] == nums[j - 1] && !visited[j - 1]) {
                continue;
            }
            if (visited[j]) {
                continue;
            }
            visited[j] = true;
            subset.add(nums[j]);
            dfs(subset, visited, nums, j+1);
            visited[j] = false;
            subset.remove(subset.size() -1);
            
        }
    }
}