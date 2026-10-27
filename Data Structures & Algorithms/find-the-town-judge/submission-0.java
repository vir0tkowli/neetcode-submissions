class Solution {
    public int findJudge(int n, int[][] trust) {
        // People are labled 1 -> n not 0 -> n-1
        int[] trustIncoming = new int[n+1];
        int[] trustGiving = new int[n+1];

        for(int[] t : trust) {
            int giving = t[0];
            int receiving = t[1];
            trustGiving[giving]++;
            trustIncoming[receiving]++;
        }

        for(int people = 1; people <= n; people++) {
            if(trustGiving[people] == 0 && trustIncoming[people] == n - 1) {
                return people;
            }
        }
        return -1;
    }
}