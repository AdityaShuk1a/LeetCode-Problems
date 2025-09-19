class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int maxPro = 1;
        int minPro = 1;

        for(int i: nums){
            if(i < 0){
                int temp = maxPro;
                maxPro = minPro;
                minPro = temp;
            }
            maxPro = Math.max(i, maxPro * i);
            minPro = Math.min(i, minPro * i);

            ans = Math.max(ans, maxPro);
        }

        return ans;
        

    }
}