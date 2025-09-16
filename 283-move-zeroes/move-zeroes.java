class Solution {
    public void moveZeroes(int[] arr) {
        int numIndex = 0;
        int zeroIndex = 0;

        while(numIndex < arr.length && zeroIndex < arr.length){

            if(arr[numIndex] != 0 && arr[zeroIndex] == 0){
                if(zeroIndex < numIndex ){

                    int temp = arr[numIndex];
                    arr[numIndex] = arr[zeroIndex];
                    arr[zeroIndex] = temp;
                    numIndex++;
                    zeroIndex++;
                }else{
                    numIndex++;
                }
            }else{
                if(numIndex <= arr.length - 1 && arr[numIndex] == 0){
                numIndex++;
                }
                if(zeroIndex <= arr.length - 1 && arr[zeroIndex] != 0){
                    zeroIndex++;
                }
            }

            


        }
    }
}