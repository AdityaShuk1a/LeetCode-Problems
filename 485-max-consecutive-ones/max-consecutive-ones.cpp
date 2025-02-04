class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int sum = 0;
        int maxx = 0;
        if(nums.size() == 1){
            if(nums[0] == 1) return 1;
            if(nums[0] == 0) return 0;

        }
        for(int i : nums){
            if( i!=0){
                sum++;
            }else{
                // cout << maxx << " ";
                
                sum = 0;
            }
                maxx = max(maxx, sum);
        }

        maxx = max(maxx, sum);
        return maxx;

    }
};