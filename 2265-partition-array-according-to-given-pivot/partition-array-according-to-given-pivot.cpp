class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        vector<int>arr1;
        vector<int>arr2;
        // unordered_map <int, int> mp;
        for(int i : nums){
            if(i < pivot){
                arr1.push_back(i);
            }
        }
        for(int i : nums){
            if(i == pivot){
                arr1.push_back(i);
            }
        }
        for(int i : nums){
            if(i > pivot){
                arr1.push_back(i);
            }
        }
        return arr1;
    }
};