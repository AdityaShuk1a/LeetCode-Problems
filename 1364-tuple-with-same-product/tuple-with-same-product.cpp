class Solution {
public:
    int tupleSameProduct(vector<int>& nums) {
        int count = 0;
        unordered_map<int, int>mp;
        for(int i = 0; i < nums.size(); i++){
            for(int j = i + 1; j < nums.size(); j++){
                int check = nums[i] * nums[j];
                count+=8*mp[check];
                mp[check]++;
            }
        }

        return count;
    }

};