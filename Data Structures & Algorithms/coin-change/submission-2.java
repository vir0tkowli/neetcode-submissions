class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int minCoins = dfs(coins, amount);  
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private int dfs(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int min = Integer.MAX_VALUE;
        for(int coin : coins) {
            if (amount - coin < 0) {
                break;
            } else {
                int res = dfs(coins, amount - coin);
                if (res != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + res);
                }
            }
        }
        memo.put(amount, min);
        return min;
    }
}
