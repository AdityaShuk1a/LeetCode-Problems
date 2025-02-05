class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        
        int countZero = 0;
        for(int i = 0; i<nums.size(); i++){
            if(nums[i] == 0){
                nums.erase(nums.begin() + i);
                countZero++;
                i--;
            }
        }

        for(int i = 0; i<countZero; i++){
            nums.push_back(0);
        }

    }
};