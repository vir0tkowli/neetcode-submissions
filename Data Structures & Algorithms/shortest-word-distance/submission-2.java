class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int word1Idx = -1;
        int word2Idx = -1;
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < wordsDict.length; i++) {
            if(wordsDict[i].equals(word1)) {
                word1Idx = i;
            } 
            if(wordsDict[i].equals(word2)) {
                word2Idx = i;
            }

            if(word1Idx != -1 && word2Idx != -1) {
                minDist = Math.min(minDist, Math.abs(word1Idx - word2Idx));
            }
        }

        return minDist;
    }
}
