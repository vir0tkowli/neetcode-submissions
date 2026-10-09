class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> money = new Stack<>();
        int maxProfit = 0;
        for(int price : prices) {
            if (money.isEmpty() || money.peek() > price) {
                money.push(price);
            } else {
                maxProfit = Math.max(maxProfit, price - money.peek()); 
            }
        }
        return maxProfit;
    }
}
