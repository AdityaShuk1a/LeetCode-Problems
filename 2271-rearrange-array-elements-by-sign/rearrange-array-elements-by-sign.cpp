class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        vector<int> positive;
        vector<int> negative;
        vector<int> result;

        for(int i: nums){
            i > 0 ? positive.push_back(i) : negative.push_back(i);
        }
        int positiveIdx = 0; 
        int negativeIdx = 0; 
        for(int i = 0; i < nums.size()/2; i++){
            result.push_back(positive[positiveIdx++]);
            result.push_back(negative[negativeIdx++]);
        }

        return result;

    }
};