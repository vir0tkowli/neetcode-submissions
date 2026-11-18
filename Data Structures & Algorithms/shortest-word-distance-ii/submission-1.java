class WordDistance {

    Map<String, List<Integer>> dict;
    public WordDistance(String[] wordsDict) {
        dict = new HashMap<>();
        for(int i = 0; i < wordsDict.length; i++) {
            dict.computeIfAbsent(wordsDict[i], key -> new ArrayList<>()).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> word1Occs = dict.get(word1);
        List<Integer> word2Occs = dict.get(word2);
        int minDist = Integer.MAX_VALUE;
        int idx1 = 0; int idx2 = 0;
        while (idx1 < word1Occs.size() && idx2 < word2Occs.size()) {
            minDist = Math.min(minDist, Math.abs(word1Occs.get(idx1) - word2Occs.get(idx2)));
            if(word1Occs.get(idx1) < word2Occs.get(idx2)) {
                idx1++;
            } else {
                idx2++;
            }
        }
        return minDist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
