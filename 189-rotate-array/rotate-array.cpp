class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        vector<int>niu;
        k = k % nums.size();
        if(nums.size() == k || nums.size() == 1){
            return ;
        }
        for(int i = nums.size()-k ; i < nums.size() ; i++){
            niu.push_back(nums[i]);
        }
        for(int i = 0; i<nums.size() - k ; i++){
            niu.push_back(nums[i]);
        }

        nums = niu;
    }
};