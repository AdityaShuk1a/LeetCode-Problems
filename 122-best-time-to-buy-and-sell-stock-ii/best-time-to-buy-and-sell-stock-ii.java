class Solution {
    int[][] dp;

    public int help(int[] prices, int i, int holding) {
        if (i == prices.length) {
            return 0;
        }

        if (dp[i][holding] != -1) {
            return dp[i][holding];
        }

        int profit;
        if (holding == 0) {
            int buy = -prices[i] + help(prices, i + 1, 1);
            int skip = help(prices, i + 1, 0);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[i] + help(prices, i + 1, 0);
            int skip = help(prices, i + 1, 1);
            profit = Math.max(sell, skip);
        }

        dp[i][holding] = profit;
        return profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return help(prices, 0, 0);
    }
}
