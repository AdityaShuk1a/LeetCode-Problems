class Solution {
    public int commonFactors(int a, int b) {
        int factors = 0;

        for (int i = 1; i <= Math.min(a, b); i++){
            if(a % i == 0 && b % i ==0){
                factors++;
            }
        }

        return factors;
    }
}