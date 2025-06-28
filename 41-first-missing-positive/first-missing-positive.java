class Solution {
    public int firstMissingPositive(int[] nums) {
        cyclicSort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }        
        return nums.length + 1;
    }
    public void cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int c = arr[i] -1;
            if(arr[i]> 0 && arr[i] < arr.length && arr[i] != arr[c]){
                swap(arr, i, c);
            }else{
                i++;
            }
        }
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}