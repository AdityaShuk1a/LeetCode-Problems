class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        unsigned long long neww = 0;
        unsigned long long n = x;
        while(n>0){
            unsigned long long temp = n%10;
            neww = neww * 10 + temp;
            n/=10;
        }

        if(neww == x){
            return true;
        }
        return false;
    }
};
