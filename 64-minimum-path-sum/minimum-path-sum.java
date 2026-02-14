class Solution {
    int[][] dp;

    public int check(int[][] grid, int row, int col, int i, int j){
        if(i >= row || j >= col) return Integer.MAX_VALUE;
        
        if(dp[i][j] != -1) return dp[i][j];

        if(i == row - 1 && j == col - 1) return grid[i][j];
        
        int down = check(grid, row, col, i + 1, j);
        
        int right = check(grid, row, col, i, j + 1);

        dp[i][j] = grid[i][j] + Math.min(down, right);

        return dp[i][j];
        
    }
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        dp = new int[row][col];

        for(int []i: dp){
            Arrays.fill(i, -1);
        }

        return check(grid, row, col, 0, 0);
    }
}