class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap<>();
        for (int i =0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0)+ 1);
        }

        Map<Character, Integer> s2SubstrMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s2SubstrMap.put(s2.charAt(i), s2SubstrMap.getOrDefault(s2.charAt(i), 0)+ 1);
        }
        int i =0 ; int j = s1.length();
        while (j < s2.length()) {
            if (s1Map.equals(s2SubstrMap)) {
                return true;
            }
            s2SubstrMap.put(s2.charAt(i), s2SubstrMap.getOrDefault(s2.charAt(i), 0)-1);
            s2SubstrMap.put(s2.charAt(j), s2SubstrMap.getOrDefault(s2.charAt(j), 0)+1);
            if (s2SubstrMap.get(s2.charAt(i)) == 0) {
                s2SubstrMap.remove(s2.charAt(i));
            }
            i++; j++;
        }
        return s1Map.equals(s2SubstrMap);
    }
}
