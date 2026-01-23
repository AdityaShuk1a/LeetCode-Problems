class Solution {
    public double myPow(double x, int n) {
        double res = 1;

        if(n < 0){
            n = -n;
            x = (double) 1 / x;
        }

        while(n != 0){
            if(n % 2 != 0){
                res *= x;
            }

            x *= x;
            n >>>= 1;

        }
        return res;
    }
}