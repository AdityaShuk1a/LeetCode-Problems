class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int newLen = len * 2;

        int[] ans = new int[newLen];
        int k = 0;
        for(int i = 0; i < newLen; i++){
            ans[i] = nums[k++ % len];
        }

        return ans;
    }
}