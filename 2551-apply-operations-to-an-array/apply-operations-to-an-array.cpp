class Solution {
public:
    vector<int> applyOperations(vector<int>& nums) {
        int countZero = 0;
        vector<int> result;
        for(int i = 0; i < nums.size()-1; i++){
            
            if(nums[i] == nums[i+1] ){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }

        for(int i = 0; i < nums.size(); i++){
            if(nums[i]!=0){
                result.push_back(nums[i]);
            }else{
                countZero++;
            }
        }
        for(int i = 0; i < countZero; i++) {
            int zero = 0;
            result.push_back(zero);
        }
        return result;

    }
};