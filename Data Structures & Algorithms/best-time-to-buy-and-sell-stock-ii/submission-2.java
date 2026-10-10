class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        Stack<Integer> money = new Stack<>();
        for (int price : prices) {
            if(!money.isEmpty() && money.peek() > price) {
                profit += money.peek() - money.firstElement();
                money.clear();
            } 
            money.push(price);
        }
        if (!money.isEmpty() && money.peek() > money.firstElement()) {
            profit += money.peek() - money.firstElement();
        }
        return profit;
    }
}