class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row + 1][col + 1];

        for(int[] i: dp){
            Arrays.fill(i, 0);
        }

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i - 1][j - 1] == '0'){
                    dp[i][j] = 0;
                }else{
                    int minn = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    if(minn == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = 1 + minn;
                    }
                }
            }
        }

        int ans = -1;

        for(int i = 0; i < row + 1; i++){
            for(int j = 0; j < col + 1; j++){
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans * ans;



    }
}