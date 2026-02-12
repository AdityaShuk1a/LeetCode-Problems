class Solution {
    int[][] dp;
    public int help(int[] coins, int amount, int i){
        if(i >= coins.length) return (int)1e9;

        if(amount == 0) return 0;
        if(amount < 0) return (int)1e9;
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        int take = 1 + help(coins, amount - coins[i], i);
        int skip = help(coins, amount, i + 1 );

        dp[i][amount] = Math.min(take, skip);

        return dp[i][amount];
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount + 1];

        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = -1;
            }
        }

        int ans = help(coins, amount, 0);

        return ans == (int)1e9 ? -1 : ans;

    }
}