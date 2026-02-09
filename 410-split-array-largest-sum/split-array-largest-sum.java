class Solution {
    // int ans = -1;
    public boolean canBe(int[] nums, int k, int mid){
        int temp = 0;
        int count = 1;
        for(int x: nums){
            // temp += x;
            if(temp + x > mid){
                count++;
                temp = x;
            }else{
                temp += x;
            }
        }
        return count <= k;
    }
    public int splitArray(int[] nums, int k) {
        int maxSum = 0;

        int low = 0;
        for(int i: nums){
            low = Math.max(i, low);
            maxSum += i;
        }

        int high = maxSum;
        int ans = high;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canBe(nums, k, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;

        
    }
}