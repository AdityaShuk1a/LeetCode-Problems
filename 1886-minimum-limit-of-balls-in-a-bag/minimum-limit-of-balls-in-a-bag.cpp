class Solution {
public:
    int minimumSize(vector<int>& nums, int maxOperations) {
        int l = 1;
        int h = *max_element(nums.begin(), nums.end());
        while(l<=h){
            int mid = l + (h - l )/ 2;
            int check = 0;
            for(int n: nums){
                check+=(n-1) / mid;
            }
            if(check <= maxOperations){
                h = mid - 1;
            }else{
                l = mid + 1;
            }

        }
        return l;
    }
};