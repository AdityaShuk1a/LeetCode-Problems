class Solution {
public:

    bool check(int n,vector <int> arr, int mid ){
        int c = 0;
        for(int x : arr){
            c+= (x+mid-1)/mid;
            if(c>n) return false;
        }
        return true;
    }
    int minimizedMaximum(int n, vector<int>& quantities) {
        int c = 0;
        int l = 1;
        int r = *max_element(quantities.begin(), quantities.end());
        int mid;
        while(l<=r){
            mid = l+(r-l)/2;
            if(check(n, quantities, mid)){
                r = mid-1;
            }else{
                l = mid+1;
            }
            
        }
        return l;
    }
};