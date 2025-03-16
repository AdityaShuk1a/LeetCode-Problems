class Solution {
public:

    bool check(vector<int>& ranks, long long& mid, int& cars){
        long count = 0;
        for(long long rank : ranks){
            count+= sqrt(mid/rank);
        }
        return count >= cars;
    }
    long long repairCars(vector<int>& ranks, int cars) {
        long long left = 1;
        long long ans;
        long long right = (long long) * min_element(ranks.begin(), ranks.end()) * cars * cars;
        while(left <= right){
            long long  mid = (left + right)/2;
            if(check(ranks, mid, cars)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return ans;
    }
};