class Solution {

    public int missingNumber(int[] arr) {
        cyclicSort(arr);
        for(int i = 0; i < arr.length; i++){
            if(i != arr[i]){
                return i;
            }
        }        
        return arr.length;
    }

    public void cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }
    }

    public void swap(int[] arr, int i, int correct){
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }
}