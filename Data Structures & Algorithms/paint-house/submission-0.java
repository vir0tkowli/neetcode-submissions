class Solution {
    public int minCost(int[][] costs) {
        int len = costs.length;
        int[][] cache = new int[len][costs[0].length];
        for(int c = 0 ; c < 3; c++) {
            cache[0][c] = costs[0][c];
        }

        for(int house = 1; house < len; house++) {
            for(int c = 0 ; c < 3; c++) {
                cache[house][c] = costs[house][c] + 
                Math.min(cache[house -1][(c+1)%3], cache[house -1][(c+2)%3]);
            }
        }
        return Math.min(cache[len -1][0], Math.min(cache[len -1][1], cache[len -1][2]));
    }
}