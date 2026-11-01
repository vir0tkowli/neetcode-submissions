class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();

        // Store every prefix of every number in arr1.
        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10;
            }
        }

        int maxLength = 0;

        for (int num : arr2) {
            while (num > 0) {
                if (prefixes.contains(num)) {
                    int length = String.valueOf(num).length();
                    maxLength = Math.max(maxLength, length);
                    break;
                }

                num /= 10;
            }
        }

        return maxLength;
    }
}