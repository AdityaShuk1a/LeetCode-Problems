class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        for(int i = 0; i < nums.length; ){
            int current = nums[i];
            if(nums[i] != nums[current]){
                int temp = nums[i];
                nums[i] = nums[current];
                nums[current] = temp;
            }else{
                i++;

            }
            
        }
        ArrayList<Integer> ans1 = new ArrayList<>();
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                ans1.add(nums[i]);
            }
        }
        int[] ans = new int[ans1.size()];

        for(int i: ans1){
            ans[k++] = i;
        }


        return ans;
    }
}