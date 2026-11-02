class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxCandies = 0;
        int minimum = 1;
        for(int candy: candies) {
            maxCandies = Math.max(maxCandies, candy); 
        }

        while(minimum <= maxCandies) {
            int res = minimum + (maxCandies - minimum)/2;
            long portions = 0;
            for(int candy : candies) {
                portions += candy/res;
            }
            if(portions >= k) {
                minimum = res + 1;
            } else {
                maxCandies = res - 1;
            }
            
        }

        return maxCandies;
    }
}
