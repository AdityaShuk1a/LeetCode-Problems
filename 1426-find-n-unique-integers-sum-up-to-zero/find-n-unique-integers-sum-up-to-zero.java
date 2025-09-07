class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int j = 0;
        if(n % 2== 0){
            for(int i = -n/2; i < 0; i++){
                res[j++] = i;
                res[j++] = i * -1;

            }

        }else{
            for(int i = -n/2; i < 0; i++){
                res[j++] = i;
                res[j++] = i * -1;

            }
            res[j] = 0;

        }

        return res;
    }
}