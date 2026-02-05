class Solution {

    public int binarySearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return -1;
    }
    public int pivotIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid < nums.length - 1 && nums[mid] > nums[mid + 1]){
                return mid;
            }else if(mid > 0 && nums[mid] < nums[mid - 1]){
                return mid - 1;   
            }
            else if(nums[mid] >= nums[0]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int len = nums.length;
        int pivotIndex = pivotIndex(nums, target);
        System.out.println(pivotIndex);
        int last = pivotIndex == -1 ? len : pivotIndex;
        int ans;
        if(pivotIndex != -1 && target >= nums[0] && target <= nums[pivotIndex]){
            ans = binarySearch(nums, 0, pivotIndex, target);
        }else if(pivotIndex == -1){
            ans = binarySearch(nums, 0, len - 1, target);
        }else{
            ans = binarySearch(nums, pivotIndex + 1, len - 1, target);
        }

        return ans;
    }
}