class Solution {
public:
    vector<int> maximumBeauty(vector<vector<int>>& items, vector<int>& queries) {
        vector <int> result;
        sort(items.begin(), items.end());

        vector<int> maxBeauty(items.size());
        maxBeauty[0] = items[0][1];

        for (int i = 1; i < items.size(); ++i) {
          maxBeauty[i] = max(maxBeauty[i - 1], items[i][1]);
        }

        for(int key : queries){
            int l = 0;
            int r = items.size()-1;
            // int key = queries[i];
            int max = 0;
            while(l<=r){
                
                int mid = l+(r-l)/2;
                if( items[mid][0] <= key ){
                   max = maxBeauty[mid]; 
                    l = mid+1;
                    // break;
                }
                else{
                    r = mid-1;
                }
            }
            result.push_back(max);
        }
        return result;
    }
};
