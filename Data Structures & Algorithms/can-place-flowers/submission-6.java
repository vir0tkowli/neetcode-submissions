class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int start = 0;
        
        while(start < flowerbed.length) {
            boolean curEmpty = (flowerbed[start] == 0);
            boolean leftEmpty = (start == 0 || flowerbed[start -1] == 0);
            boolean rightEmpty = (start == flowerbed.length -1 || flowerbed[start + 1] == 0);

            if(curEmpty && leftEmpty && rightEmpty) {
                flowerbed[start] = 1;
                n--;
                start +=2;
            } else {
                start++;
            }
        }

        return (n < 1);
    }
}