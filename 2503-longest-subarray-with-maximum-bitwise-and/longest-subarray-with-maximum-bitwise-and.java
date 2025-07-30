class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxVal = Math.max(nums[i], maxVal);
        }

        int len = 0;
        int maxLen = 0;
        for(int i: nums){
            if(i == maxVal){
                len++;
                maxLen = Math.max(len, maxLen);
            }else{
                len = 0;
            }
        }

        return maxLen;
    }

    
}