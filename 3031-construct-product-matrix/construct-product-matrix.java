class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int row = grid.length;
        int col = grid[0].length;

        int n = row * col;

        int[] arr = new int[n];
        int k = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[k++] = grid[i][j];
            }
        }

        long[] prefix = new long[n];
        prefix[0] = arr[0] % mod;
        long[] suffix = new long[n];
        suffix[n - 1] = arr[n - 1] % mod;

        for(int i = 1; i < n; i++){
            prefix[i] = (prefix[i - 1] * arr[i]) % mod;
        }

        for(int i = n - 2; i >= 0; i--){
            suffix[i] = (suffix[i + 1] * arr[i]) % mod;
        }

        int[][] res = new int[row][col];
        int idx = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                long left = idx == 0 ? 1 : prefix[idx - 1];
                long right = idx == n - 1 ? 1 : suffix[idx + 1];

                res[i][j] = (int)(left * right) % mod;
                idx++;
            }
        }

        return res;


    }
}