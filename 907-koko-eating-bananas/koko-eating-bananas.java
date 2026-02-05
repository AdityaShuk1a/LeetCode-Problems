class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxx = Integer.MIN_VALUE;
        for(int i : piles){
            if(i > maxx){
                maxx = i;
            }
        }

        int left = 1;
        int right = maxx;
        int ans = maxx;

        while(left <= right){
            int mid = left + (right - left) / 2;
            long totalHours = 0;  

            for(int pile : piles){
                if(pile % mid == 0){
                    totalHours += pile / mid;
                }else{
                    totalHours += (pile / mid) + 1;
                }
            }

            if(totalHours <= h){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }
}
