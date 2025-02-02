class Solution {
public:
    bool check(vector<int>& nums) {
        int flag = nums[0];
        int idx = 0;
        for(int i = 0; i<nums.size()-1; i++){
            if(nums[i] > nums[i+1] ){
                idx = i+1;
                break;
            }
        }
        // if(idx == nums.size()-1){
        //     if(nums[idx] > nums[0] ){
        //         return false;
        //     }
        //     else{
        //         return true;
        //     }
        // }
        for(int i = idx; i<nums.size()-1; i++){
            if(nums[i] > nums[i+1]){
                return false;
            }
        }
        if(idx > 0 && nums.back() > nums[0]){
            return false;
        }
        return true;
    }
};