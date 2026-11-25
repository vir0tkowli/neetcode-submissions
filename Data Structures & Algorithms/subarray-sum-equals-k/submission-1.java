class Solution {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int count = 0;
        int runningSum = 0;
        for(int n : nums) {
            runningSum += n;
            int diff = runningSum - k;
            if(prefixSum.containsKey(diff)) {
                //prefixSum.put(0, prefixSum.get(0) + 1);
                count += prefixSum.get(diff);
            }
            prefixSum.put(runningSum, prefixSum.getOrDefault(runningSum, 0) + 1);
        }

        return count;
        
    }


    public int subarraySumInefficient(int[] nums, int k) {
        int maxSum = 0;

        for(int i = 0; i < nums.length; i++) {
            int runningSum = 0;
            for(int j = i; j < nums.length; j++) {
                runningSum += nums[j];
                if(runningSum == k) {
                    maxSum++;
                }
            }
        }

        return maxSum;
    }
}