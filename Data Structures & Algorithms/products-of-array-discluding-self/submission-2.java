class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProd = new int[nums.length];
        prefixProd[0] = 1;
        int[] suffixProd = new int[nums.length];
        suffixProd[nums.length -1] = 1;

        for (int start = 1; start < nums.length; start++) {
            prefixProd[start] = prefixProd[start - 1] * nums[start - 1] ;
        }
        for (int start = nums.length -2; start >= 0; start--) {
            suffixProd[start] = suffixProd[start + 1] * nums[start + 1] ;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefixProd[i] * suffixProd[i];
        }
        return res;
    }
}  
