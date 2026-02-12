class Solution {
    int[][] dp;
    int count = 0;

    public int help(int[] coins, int amount, int i){
        if(amount == 0) {
            count++;
            return 1;
        }

        if(amount < 0) return 0;

        if(i >= coins.length) return 0;
        
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        int take = help(coins, amount - coins[i], i);
        int skip = help(coins, amount, i + 1);
        dp[i][amount] = take + skip;

        return dp[i][amount];
        
    }


    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount + 1];

        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = -1;
            }
        }
        return help(coins, amount, 0);
        // return count;
    }
}