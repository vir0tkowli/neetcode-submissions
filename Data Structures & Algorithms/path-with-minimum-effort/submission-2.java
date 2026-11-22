class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));

        queue.offer(new Pair<>(0, new Pair<>(0,0)));
        int[][] result = new int[heights.length][heights[0].length];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        result[0][0] = 0;

        while(!queue.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> current = queue.poll();
            int delta = current.getKey();
            int currentRow = current.getValue().getKey();
            int currentCol = current.getValue().getValue();

            // if(currentRow == heights.length -1 && currentCol == heights[0].length -1) {
            //     return delta;
            // }

            int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

            for(int[] dir : dirs) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];

                if(newRow < 0 || newCol < 0 || newRow >= heights.length || newCol >= heights[0].length) {
                    continue;
                }
                
                int newDelta = Math.max(delta, Math.abs(heights[currentRow][currentCol] - heights[newRow][newCol]));
                if(result[newRow][newCol] > newDelta) {
                    result[newRow][newCol] = newDelta;
                    queue.offer(new Pair<>(newDelta, new Pair<>(newRow, newCol)));
                }

            }

        }
        return result[heights.length -1][heights[0].length -1];
    }
}