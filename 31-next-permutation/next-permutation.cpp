class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int j = nums.size() - 1;
        
        while (j > 0 && nums[j] <= nums[j - 1]) {
            j--;
        }
        
        if (j == 0) {
            reverse(nums.begin(), nums.end());
            return;
        }
        
        int checkGreater = j - 1;
        int minn = INT_MAX;
        int minIdx = -1;

        for (int i = nums.size() - 1; i > checkGreater; --i) {
            if (nums[i] > nums[checkGreater]) {
                minIdx = i;
                break;
            }
        }

        swap(nums[checkGreater], nums[minIdx]);

        reverse(nums.begin() + j, nums.end());
    }
};
