class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l = 0;
        int right = nums.size()-1;
        while(l<=right){
            int mid = l+(right-l)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(target > nums[mid]){
                l = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
};