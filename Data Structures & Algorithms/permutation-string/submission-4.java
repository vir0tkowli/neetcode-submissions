class Solution {
    public boolean checkInclusion(String s1, String s2) {

        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        String sorteds1 = new String(chars);

        int i = 0; int j = s1.length();
        while (j <= s2.length()) {
            char[] newChars = s2.substring(i, j).toCharArray();
            Arrays.sort(newChars);
            String sorteds2 = new String(newChars);
            if (sorteds1.equals(sorteds2)) {
                return true;
            } else {
                i++; j++;
            }
        }
        return false;
    }
}
