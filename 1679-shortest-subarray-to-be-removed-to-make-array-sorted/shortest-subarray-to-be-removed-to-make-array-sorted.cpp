class Solution {
public:
    int findLengthOfShortestSubarray(vector<int>& arr) {
        int r = arr.size()-1;
        int l = 0;
        while(r > 0 && arr[r] >= arr[r-1]){
            r--;
        }

        if(r == 0){
            return 0;
        }
        int minn = r;
        while(l < r && (l == 0 || arr[l] >= arr[l-1])){
            while(r < arr.size() && arr[l] > arr[r]){
                r++;
            }

            minn =  min(minn, r-l-1);
            l++;
        }

        return minn;
    }
};