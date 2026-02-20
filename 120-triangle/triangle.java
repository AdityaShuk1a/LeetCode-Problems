class Solution {
    int[][] dp;
    public int check(List<List<Integer>> triangle, int i, int j, int row){
        if(i == row - 1) return triangle.get(i).get(j);

        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int down = triangle.get(i).get(j) + check(triangle, i + 1, j, row);
        int downRight = triangle.get(i).get(j) + check(triangle, i + 1, j + 1, row);

        dp[i][j] = Math.min(down, downRight);

        return dp[i][j];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];
        for(int[] i: dp){
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        return check(triangle, 0, 0, n);
    }
}