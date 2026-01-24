class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxx = Integer.MIN_VALUE;

        for(int i : nums){
            maxx = Math.max(i, maxx);
        }

        // for(int i = 1; i <= maxx; i++){
        //     int sum = 0;

        //     for(int j = 0; j < nums.length; j++){
        //         sum += Math.ceil((double)nums[j] / (double)i);
        //         System.out.print(sum + " ");
        //     }
        //     System.out.println();

        //     if(sum <= threshold) return i;
        // }

        int[] divisor = new int[maxx];

        for(int i = 0; i < maxx; i++){
            divisor[i] = i + 1;
        }

        int left = 0;
        int right = divisor.length - 1;
        int result = divisor[0];
        while(left <= right){
            int mid = left + (right - left) / 2;

            int key = divisor[mid];

            int sum = 0;

            for(int i: nums){
                sum += Math.ceil((double) i / key);
            }

            if(sum > threshold){
                left = mid + 1;
            }else{
                result = key;
                right = mid - 1;
            }
        }

        return result;
    }
}