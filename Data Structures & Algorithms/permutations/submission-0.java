class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }
        List<Integer> subsets = new ArrayList<>();
        perms(nums, new boolean[nums.length], subsets);
        return result;
    }

    private void perms(int[] nums, boolean[] visited, List<Integer> subsets) {
       
        if(subsets.size() == nums.length) {
            result.add(new ArrayList<>(subsets));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }

            visited[i] = true;
            subsets.add(nums[i]);
            perms(nums, visited, subsets);

            subsets.remove(subsets.size() - 1);
            visited[i] = false;
        }
    }
}
