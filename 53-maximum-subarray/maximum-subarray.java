class Solution {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int maxSubSum = 0;

        for(int i: nums){
            maxSubSum = Math.max(i, maxSubSum + i);

            sum = Math.max(sum, maxSubSum);
        }

        sum = Math.max(sum, maxSubSum);

        return sum;
    }
}