class Solution {
public:
    int maximumSum(vector<int>& nums) {
        unordered_map<int, pair<int, int>> sumOfDigit; 
        for (int i : nums) {
            int temp = i;
            int sum = 0;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sumOfDigit.find(sum) == sumOfDigit.end()) {
                sumOfDigit[sum] = {i, -1};
            } else {
                if (i > sumOfDigit[sum].first) {
                    sumOfDigit[sum].second = sumOfDigit[sum].first;
                    sumOfDigit[sum].first = i;
                } else if (i > sumOfDigit[sum].second) {
                    sumOfDigit[sum].second = i;
                }
            }
        }
        int maxx = -1;

        for ( auto pair : sumOfDigit) {
            if (pair.second.second != -1) {
                maxx = max(maxx, pair.second.first + pair.second.second);
            }
        }

        return maxx;
    }
};
