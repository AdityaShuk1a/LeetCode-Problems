/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findPeak(MountainArray arr){
        int start = 0;
        int end = arr.length() - 1;

        while(start != end){
            int mid = start + (end - start) /2 ;
            if(arr.get(mid) > arr.get(mid+1)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }

    public int binarySearch(MountainArray arr, int start, int end, int target, boolean increasing){
        int mid = 0;
        if(increasing){
            while(start <= end){
                mid = start + (end - start) / 2;
                if(arr.get(mid) == target){
                        return mid;
                }else if(target < arr.get(mid)){
                        end = mid - 1;
                }else{
                        start = mid + 1;
                }
            }
        }else{
            while(start <= end){
                mid = start + (end - start) / 2;
                if(arr.get(mid) == target){
                        return mid;
                }else if(target > arr.get(mid)){
                        end = mid - 1;
                }else{
                        start = mid + 1;
                }
            }
        }
        
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int ans = -1;
        int ans2 = -1;
        

        int peak = findPeak(mountainArr);
        ans = binarySearch(mountainArr, 0, peak, target, true);
        ans2 = binarySearch(mountainArr, peak, mountainArr.length() - 1, target, false);
        System.out.println(ans + " " + ans2);
        if(ans >= 0 && ans2 >= 0){
            return Math.min(ans, ans2);
        }else if(ans >= 0){
            return ans;
        }else{
            return ans2;
        }
        
    }
}