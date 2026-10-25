class Solution {
    Set<List<Integer>> result = new HashSet<>();
    List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(subset, n, 1, k);
        return new ArrayList<>(result);
    }

    private void dfs(List<Integer> subset, int n, int index, int k) {
        if(subset.size() == k) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int j = index; j <= n; j++) {
            // if (index > k) {
            //     break;
            // }
            subset.add(j);
            dfs(subset, n, j + 1, k);
            subset.remove(subset.size() -1);
        }                
    }
}