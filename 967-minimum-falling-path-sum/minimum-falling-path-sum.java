class Solution {
    int[][] dp;
    public int f(int[][] g, int i, int j, int row, int col){
        if(j >= col || j < 0) return (int)1e9;
        if(i == row - 1) return g[i][j];

        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int rightDiag = f(g, i + 1, j - 1, row, col);
        int leftDiag = f(g, i + 1, j + 1, row, col);
        int bottom = f(g, i + 1, j, row, col);

        dp[i][j] = g[i][j] + Math.min(rightDiag, Math.min(leftDiag, bottom));

        return dp[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        dp = new int[row][col];
        for(int[] i: dp){
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < col; i++){
            ans = Math.min(ans, f(matrix, 0, i, row, col));
        }

        return ans;
    }
}