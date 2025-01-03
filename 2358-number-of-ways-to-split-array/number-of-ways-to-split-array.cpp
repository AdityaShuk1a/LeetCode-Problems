class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        vector <long long> prefS(nums.size()+1, 0);
        // prefS[0] = nums[0];
        for(int i = 0; i<nums.size(); i++){
            prefS[i+1] = prefS[i] + nums[i];
        }
        int count = 0;
        for(int i= 1; i<nums.size(); i++){
            if(prefS[i] >= prefS[nums.size()] - prefS[i]){
                count++;
            }
        }
        return count;
    }
};