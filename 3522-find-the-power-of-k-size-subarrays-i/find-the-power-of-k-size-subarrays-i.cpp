class Solution {
public:
    vector<int> resultsArray(vector<int>& nums, int k) {
        // int s = 0;
        int n = nums.size();
        vector<int> s(n, 1);
        for(int i=1; i<n; i++){
            if(nums[i]-nums[i-1] == 1)
            s[i] = s[i-1]+1;

        }
        vector <int> result(n-k+1, -1);
        for(int i = 0; i<n; i++){
            if(s[i] >= k){
                result[i-k+1] = nums[i]; 
            }
        }

        return result; 
    }
};