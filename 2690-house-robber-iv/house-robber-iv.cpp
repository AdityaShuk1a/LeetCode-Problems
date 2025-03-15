class Solution {
public:
    
    bool check(vector<int>& nums, int k, int mid){
        int count = 0;
        int i = 0;
        while(i < nums.size()){
            if(nums[i] <= mid){
                i+=2;
                count++;
            }
            else{
                i++;
            }
        }

        return count >= k;
    }

    int minCapability(vector<int>& nums, int k) {
        int left = *min_element(nums.begin(), nums.end());
        int right = *max_element(nums.begin(), nums.end());
        int ans = right;

        while(left < right){
            int mid = (right + left) / 2;
            if(check(nums, k, mid)){
                ans = right;
                right = mid ;

            }else{
                left = mid + 1;
            }
        }
        return left;
    }
};