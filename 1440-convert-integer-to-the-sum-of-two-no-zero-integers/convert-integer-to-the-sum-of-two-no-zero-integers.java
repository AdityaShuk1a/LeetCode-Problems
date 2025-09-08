class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        for(int i = 1; i < n; i++ ){
            if(check(i) && check(n - i)){
                res[0] = i;
                res[1] = n - i;
                return res;
            }
        }
        
        return res;
    }

    public boolean check(int num){
        while(num > 0){
            if(num % 10 == 0) return false;
            num/=10;
        }
        return true;
    }
}