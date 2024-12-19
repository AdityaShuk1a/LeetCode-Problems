class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        vector<int>s = arr;
        sort(s.begin(), s.end());
        int c = 0;
        int i = -1;
        for(int j = 0; j <arr.size(); j++){
            i = max(i, int(find(s.begin(), s.end(), arr[j]) - s.begin()));
            if(i == j){
                c++;
            }
        }
        return c;
    }
};