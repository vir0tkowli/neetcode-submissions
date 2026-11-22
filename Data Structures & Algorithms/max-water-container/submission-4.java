class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length -1;

        int maxVolume = 0;

        while(start < end) {
            int width = end - start;
            int height = Math.min(heights[start], heights[end]);
            //System.out.printf("** width %d height %d\n", width, height);
            maxVolume = Math.max(maxVolume, width * height);
            if(heights[start] > heights[end]) {
                end--;
            } else {
                start++;
            }
        }
        return maxVolume;
    }
}
