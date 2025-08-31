class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int current = nums[i];
            if(nums[i] != nums[current]){
                swap(nums, current, i);
            }else{
                i++;
            }
        }
        int ans = -1;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j+1){
                ans = nums[j];
                break;
            }
        }

        return ans;

    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}