class WordDistance {

    String[] dict;
    public WordDistance(String[] wordsDict) {
        dict = wordsDict;
    }
    
    public int shortest(String word1, String word2) {
        int w1 = -1;
        int w2 = -1;
        int minDist = Integer.MAX_VALUE;
        for(int i =0; i < dict.length; i++) {
            if(dict[i].equals(word1)) {
                w1 = i;
            }
            if(dict[i].equals(word2)) {
                w2 = i;
            }

            if(w1 != -1 && w2 != -1) {
                minDist= Math.min(minDist, Math.abs(w2 -w1));
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
