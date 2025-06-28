class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        cyclicSort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                arr.add(i + 1);
            }
        } 
        return arr;       
    }

    public void cyclicSort(int[] arr){
        int i = 0;
        while( i < arr.length){
            int correct = arr[i] - 1 ;
            if(arr[i] <= arr.length && arr[i] != arr[correct] ){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }
    }

    public void swap(int[] arr, int i, int b){
        int temp = arr[i];
        arr[i] = arr[b];
        arr[b] = temp;
    }
}