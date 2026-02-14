class Solution {
    int maxSum = 0;
    Boolean[][] dp;
    public boolean check(int[] nums, int i, int targetSum, int currSum){
        if(currSum == targetSum) return true;
        if(i >= nums.length || currSum > targetSum) return false;

        if(dp[i][currSum] != null)
        return dp[i][currSum];

        boolean take = check(nums, i + 1, targetSum, currSum + nums[i]);
        boolean skip = check(nums, i + 1, targetSum, currSum);
        
        dp[i][currSum] = take || skip;

        return dp[i][currSum];

    }
    public boolean canPartition(int[] nums) {

        for(int i: nums){
            maxSum += i;
        }
        if(maxSum % 2 != 0) return false;
        dp = new Boolean[nums.length][maxSum + 1];

        return check(nums, 0, maxSum / 2, 0);
    }
}