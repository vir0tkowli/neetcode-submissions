class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int minRate = piles[piles.length -1];
        int start = 1;
        int end = piles[piles.length -1];
        
        while (start <= end) {
            int mid = (end + start)/2;
            int eachPileRate = 0;
            for(int pile: piles) {
                eachPileRate += pile / mid;
                if (pile % mid != 0) {
                    eachPileRate++;
                }                
            }
            if (eachPileRate <= h) {
                minRate = Math.min(minRate, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return minRate;
    }
}
