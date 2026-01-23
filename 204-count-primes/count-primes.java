class Solution {
    public int countPrimes(int n) {
        if(n < 2){
            return 0;
        }

        int count = 0;
        boolean[] prime = new boolean[n];

        for(int i = 0; i < prime.length; i++){
            prime[i] = true;
        }

        prime[0] = false;
        prime[1] = false;

        for(int i = 0; i < prime.length; i++){
            if(prime[i]){
                for(int j = i + i; j < prime.length; j = j + i){
                    prime[j] = false;
                }
            }
        }

        for(boolean i: prime){
            if(i) count++;
        }

        return count;
    }
}