class Solution {
    public int check(int[][] dp, int m, int n, int i, int j){
        if(i >= m || j >= n){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == m - 1 && j == n - 1) return 1;

        dp[i][j] = check(dp, m, n, i + 1, j) + check(dp, m, n, i, j + 1);

        return dp[i][j];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }

        return check(dp, m, n, 0, 0);
    }
}