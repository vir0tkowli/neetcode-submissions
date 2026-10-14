class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<List<Integer>> res = new HashSet<>();
        for (int i =0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        for (int i =0; i < nums.length; i++) {
            for (int j = i+ 1; j < nums.length; j++) {
                int delta = 0-nums[j]-nums[i];
                if (map.containsKey(delta)) {
                    List<Integer> indices = map.get(delta);
                    if(indices != null && indices.get(indices.size() - 1) > j) {
                        List<Integer> triplet = new ArrayList<>(List.of(nums[i], nums[j], delta));
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}
