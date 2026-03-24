class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums.length % k != 0) return false;
        // else return false;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i: nums){
            arr.add(i);
        }
        int prev = -1;
        int count = 0;
        
        while(!arr.isEmpty()){
            prev = arr.get(0);
            count = 1;
            arr.remove(0);
            for(int i = 0; i < arr.size() && count < k; i++){
                if(prev + 1== arr.get(i)){
                    prev = arr.get(i);
                    arr.remove(i);
                    i--;
                    count++;    
                }
            }

            if(count != k) return false;
        }
        return true;
    }
}