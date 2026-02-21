class Solution {
    int[][] dp;
    public int check(ArrayList<Integer> ps, int n, int i){
        if(n == 0) return 0;
        if(i >= ps.size() || n < 0) return Integer.MAX_VALUE;
        // if(n < 0) return Integer.MAX_VALUE;
        if(dp[i][n] != -1) return dp[i][n];

        int take = Integer.MAX_VALUE;

        int res = check(ps, n - ps.get(i), i);
        if (res != Integer.MAX_VALUE) {
            take = 1 + res;
        }
        int skip = check(ps, n, i + 1);

        dp[i][n] = Math.min(take, skip);

        return dp[i][n];

    }
    public int numSquares(int n) {
        ArrayList<Integer> ps = new ArrayList<>();

        for(int i = 1; i <= Math.sqrt(n); i++){
            ps.add(i * i);
        }

        dp = new int[ps.size()][n + 1];
        for(int[] i: dp) Arrays.fill(i, -1);
        return check(ps, n, 0);


    }
}