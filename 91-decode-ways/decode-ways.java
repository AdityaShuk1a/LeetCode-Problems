class Solution {
    int[] dp;
    public int help(String s, int i){
        if(i == s.length()){
            return 1;
        }

        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1){
            return dp[i];
        }

        dp[i] = 0;

        dp[i] += help(s, i + 1);
        if(i + 1 < s.length()){
            int twoDigits = Integer.parseInt(s.substring(i, i + 2));
            if(10 <= twoDigits && twoDigits <= 26){
                dp[i] += help(s, i + 2);
            }
        }

        return dp[i];

    }
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return help(s, 0);
    }
}