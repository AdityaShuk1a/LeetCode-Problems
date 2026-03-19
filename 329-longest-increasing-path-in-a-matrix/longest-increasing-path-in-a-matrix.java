class Solution {
    int ans = 1;
    int dp[][];
    public int longestIncreasingPath(int[][] matrix) {
        int row  = matrix.length;
        int col = matrix[0].length;
        dp = new int[row][col];

        boolean[][] vis = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                vis[i][j] = false;
            }
        }


        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                ans = Math.max(ans, dfs(matrix, i, j, row, col));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int i, int j, int row, int col){
        
        // vis[i][j] = true;
        if(dp[i][j] != 0) return dp[i][j];
        int maxPath = 1;
        int[][] dfs = {{-1 , 0}, {1, 0}, {0, 1}, {0, -1}};

        for(int[] k: dfs){
            if(i + k[0] >= 0 && i + k[0] < row && j + k[1] >= 0 && j + k[1] < col){
                if(matrix[i + k[0]][j + k[1]] > matrix[i][j]){
                    maxPath = Math.max(maxPath, 1 + dfs(matrix, i + k[0], j + k[1], row, col));
                    
                }
            }
        }
        // vis[i][j] = false;
        dp[i][j] = maxPath;
        return maxPath;
    }
}