class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        sort(nums.begin(), nums.end());
        long long c = 0;
        for(int i=0; i<nums.size(); i++){
            int l = i+1;
            int r = nums.size()-1;

            while(l<=r){
                int mid = l+(r-l)/2;
                if(nums[mid]+nums[i] >= lower){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
            int start = l;
            l = i+1;
            r = nums.size()-1;
            
            while(l<=r){
                int mid = l+(r-l)/2;
                if(nums[mid]+nums[i] > upper){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
            int end = r;

            if(start <= end){
                c+= end-start+1;
            }
        }
        return c;
    }
};