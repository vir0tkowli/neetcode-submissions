class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int startWeight = 0;
        int maxWeight = 0;
        int minDays = Integer.MAX_VALUE;
        
        for (int weight : weights) {
            startWeight = Math.max(startWeight, weight);
            maxWeight += weight;
        }
        
        while (startWeight < maxWeight) {
            int resWeight = startWeight + (maxWeight - startWeight)/2;
            int capacity = 0;
            int curDays = 1;
            for(int weight: weights) {
                if (capacity + weight > resWeight) {
                    curDays++;
                    capacity = 0;
                }
                capacity += weight;
            }
            minDays = Math.min(minDays, curDays);
            if(curDays > days) {
                startWeight = resWeight + 1;
            } else {
                maxWeight = resWeight;
            }
        }
        return startWeight;
    }
}