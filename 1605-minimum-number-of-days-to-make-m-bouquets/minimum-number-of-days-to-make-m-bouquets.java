class Solution {
    public boolean canBloom(int[] bloomDay, int day ,int m, int k){
        int count = 0;
        int bq = 0;
        for(int x: bloomDay){
            if(x <= day){
                count++;
                if(count == k){
                    bq++;
                    count = 0;
                }
            }else{
                count = 0;
            }
        }

        return bq >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int maxDay = Integer.MIN_VALUE;

        for(int i: bloomDay) maxDay = Math.max(i, maxDay);

        int low = 1;
        int high = maxDay;

        int ans = -1;
        while(low <= high){
            int day = low + (high - low) / 2;
            if(canBloom(bloomDay, day, m, k)){
                ans = day;
                high = day - 1;
            } else{
                low = day + 1;
            }
        }   

        return ans;
    }
}