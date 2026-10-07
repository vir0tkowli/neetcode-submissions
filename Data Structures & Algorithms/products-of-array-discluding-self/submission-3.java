class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int total = 1;
        int numZero = 0;
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] == 0 ) {
                numZero++;
                continue;
            }
            total *= nums[i];
        }
        if (numZero > 1) {
            return res;
        }
        for (int i =0; i< nums.length; i++) {
            if (numZero > 0) {
                if (nums[i] == 0 ) {
                    res[i] = total;
                } else {
                    res[i] = 0;
                }
            } else {
                res[i] = total/nums[i];
            }   
        }
        return res;
    }
}  
