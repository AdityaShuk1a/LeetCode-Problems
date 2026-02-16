class Solution {
    int[] dp;
    public int check(int[] cost, int i){
        if(i >= cost.length) return 0;
        if(dp[i] != -1) return dp[i];

        int take = check(cost, i + 1);
        int skip = check(cost, i + 2);

        dp[i] = cost[i] + Math.min(take, skip);

        return dp[i];

    }
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        int ans1 = check(cost, 0);
        dp = new int[cost.length];
        Arrays.fill(dp, -1);
        int ans2 = check(cost, 1);
        return Math.min(ans2, ans1);
    }
}