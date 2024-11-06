class Solution {
public:
    bool check(vector<int>piles, int h, int speed){
        int hrs = 0;
        for(int pile:piles){
            hrs+=ceil((double)pile/speed);
        }
        return hrs <=h;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int left = 1; int right = 1;
        right = *max_element(piles.begin(), piles.end());
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(check(piles, h, mid)){
                right = mid;
            }else{
                left = mid+1;
            }


        }
        return left;

    }

};