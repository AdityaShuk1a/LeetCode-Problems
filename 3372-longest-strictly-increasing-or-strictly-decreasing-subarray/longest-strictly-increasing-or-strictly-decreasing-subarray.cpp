class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        int inc = 1;
        int maxInc = 1;
        int dec = 1;
        int maxDec = 1;

        for(int i = 0; i<nums.size()-1; i++){
            if(nums[i] < nums[i+1]){
                inc++;
            }else{
                maxInc = max(maxInc, inc);
                inc=1;
            }
            if(nums[i] > nums[i+1]){
                dec++;
            }else{
                maxDec = max(maxDec, dec);
                dec=1;
            }

        }
        maxInc = max(maxInc, inc);
        maxDec = max(maxDec, dec);

        return  max(maxInc, maxDec);
    }
};