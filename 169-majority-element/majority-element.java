class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = -1;

        for(int i: nums){
            if(count == 0){
                candidate = i;
                count += 1;
            }else if(candidate == i){
                count++;
            }else{
                count--;
            }
            
        }
        count = 0;
        int majority = candidate;
        for(int i: nums){
            if(i == majority){
                count++;
            }
        }

        if(count > nums.length / 2){
            return majority;
        }else{
            return -1;
        }
    }
}