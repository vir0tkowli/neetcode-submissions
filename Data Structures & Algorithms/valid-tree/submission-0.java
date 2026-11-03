class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjacencyMatrix = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adjacencyMatrix.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjacencyMatrix.get(edge[0]).add(edge[1]);
            adjacencyMatrix.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();

        boolean isCycle = dfs(0, -1, visited, adjacencyMatrix);

        boolean isConnected = visited.size() == n;

        return isCycle && isConnected;
    }

    private boolean dfs(int node, int parent, Set<Integer> visited, Map<Integer, List<Integer>> adjacencyMatrix) {
        if (visited.contains(node)) {
            return false;
        }
        
        visited.add(node);
        for(Integer neighbor : adjacencyMatrix.get(node)) {
            // undirected graph
            if (neighbor == parent) {
                continue;
            }
            if(!dfs(neighbor, node, visited, adjacencyMatrix)) {
                return false;
            }
        } 
        return true;
    }
}
